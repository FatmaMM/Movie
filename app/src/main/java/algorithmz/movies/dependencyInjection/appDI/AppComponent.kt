package algorithmz.movies.dependencyInjection.appDI

import algorithmz.movies.dependencyInjection.databaseDI.DataBaseModule
import algorithmz.movies.dependencyInjection.networkDI.NetworkModule
import algorithmz.movies.moviedetails.internal.di.MovieDetailsComponent
import algorithmz.movies.moviedetails.internal.di.MovieDetailsModule
import algorithmz.movies.toprated.internal.di.TopRatedMoviesComponent
import algorithmz.movies.toprated.internal.di.TopRatedMoviesModule
import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataBaseModule::class])
interface AppComponent {
    fun application(): Application
//    fun appDatabase(): AppDataBase
    fun add(topRatedMoviesModule: TopRatedMoviesModule): TopRatedMoviesComponent
    fun add(movieDetailsModule: MovieDetailsModule): MovieDetailsComponent

}