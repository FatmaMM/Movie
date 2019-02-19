package algorithmz.movies

import algorithmz.movies.dependencyInjection.appDI.AppComponent
import algorithmz.movies.dependencyInjection.appDI.AppModule
import algorithmz.movies.dependencyInjection.appDI.DaggerAppComponent
import algorithmz.movies.dependencyInjection.databaseDI.DataBaseModule
import algorithmz.movies.dependencyInjection.networkDI.NetworkModule
import algorithmz.movies.moviedetails.internal.di.MovieDetailsComponent
import algorithmz.movies.moviedetails.internal.di.MovieDetailsModule
import algorithmz.movies.toprated.internal.di.TopRatedMoviesComponent
import algorithmz.movies.toprated.internal.di.TopRatedMoviesModule
import android.content.Context
import android.support.multidex.MultiDexApplication

class MovieApp : MultiDexApplication() {
    private var applicationComponent: AppComponent? = null
    private var topRatedMoviesComponent: TopRatedMoviesComponent? = null
    private var movieComponent: MovieDetailsComponent? = null

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent()
    }

    private fun getApplicationComponent(): AppComponent? {
        if (applicationComponent == null)
            applicationComponent = DaggerAppComponent.builder().appModule(AppModule(this))
                .networkModule(NetworkModule())
                .dataBaseModule(DataBaseModule())
                .build()

        return applicationComponent
    }

    fun setUpTopRatedActivityComponent(): TopRatedMoviesComponent? {
        topRatedMoviesComponent = applicationComponent!!.add(TopRatedMoviesModule())
        return topRatedMoviesComponent
    }

    fun deleteTopRatedComponent() {
        topRatedMoviesComponent = null
    }

    fun setUpMoviesActivityComponent(): MovieDetailsComponent? {
        movieComponent = applicationComponent!!.add(MovieDetailsModule())
        return movieComponent
    }

    fun deletMovieComponent() {
        movieComponent = null
    }

    companion object {
        fun get(context: Context): MovieApp {
            return context.applicationContext as MovieApp
        }
    }

}