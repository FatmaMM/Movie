package algorithmz.movies.moviedetails.internal.di

import algorithmz.movies.moviedetails.data.repository.MovieDetailsAPI
import algorithmz.movies.moviedetails.data.repository.MovieDetailsRepoImplementation
import algorithmz.movies.moviedetails.domain.datarepository.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MovieDetailsModule {
    @Provides
    fun provideMovieDetailsAPI(retrofit: Retrofit)=retrofit.create(MovieDetailsAPI::class.java)
    @Provides
    fun provideMovieDetailsRepo(movieDetailsAPI: MovieDetailsAPI): MovieDetailsRepo =MovieDetailsRepoImplementation(movieDetailsAPI)
}