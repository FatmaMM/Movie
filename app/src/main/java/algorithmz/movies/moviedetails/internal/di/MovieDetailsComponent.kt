package algorithmz.movies.moviedetails.internal.di

import algorithmz.movies.moviedetails.presentation.view.MovieDetailsActivity
import dagger.Subcomponent

@MovieDetailsScope
@Subcomponent(modules = [MovieDetailsModule::class])
interface MovieDetailsComponent {
    fun inject(movieDetailsActivity: MovieDetailsActivity)
}