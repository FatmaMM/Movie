package algorithmz.movies.moviedetails.data.repository

import algorithmz.movies.moviedetails.domain.datarepository.MovieDetailsRepo
import algorithmz.movies.moviedetails.domain.entities.Movie
import algorithmz.movies.moviedetails.domain.entities.TrailerResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MovieDetailsRepoImplementation @Inject constructor(val movieDetailsAPI: MovieDetailsAPI) : MovieDetailsRepo {
    override fun getTrailers(id: Int): Observable<TrailerResponse> = movieDetailsAPI.getMovieTrailers(id)

    override fun getMovie(id: Int): Single<Movie> = movieDetailsAPI.getMovieDetails(id)
}