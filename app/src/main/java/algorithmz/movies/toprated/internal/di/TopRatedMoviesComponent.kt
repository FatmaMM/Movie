package algorithmz.movies.toprated.internal.di

import algorithmz.movies.toprated.presentation.view.TopRatedActivity
import dagger.Subcomponent

@TopRatedActivityScope
@Subcomponent(modules = [TopRatedMoviesModule::class])
interface TopRatedMoviesComponent {
    fun inject(topRatedActivity: TopRatedActivity)

}