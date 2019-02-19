package algorithmz.movies.moviedetails.domain.interactors

import algorithmz.movies.moviedetails.domain.datarepository.MovieDetailsRepo
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val movieDetailsRepo: MovieDetailsRepo) {
    fun getMovieDetails(movieId: Int) = movieDetailsRepo.getMovie(movieId)
    fun getTrailers(movieId: Int) = movieDetailsRepo.getTrailers(movieId)
}