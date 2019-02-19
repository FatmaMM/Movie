package algorithmz.movies.toprated.domain.interactor

import algorithmz.movies.toprated.domain.datarepository.TopRatedMoviesRepo
import algorithmz.movies.toprated.domain.entities.Genre
import algorithmz.movies.toprated.domain.entities.GenreResult
import algorithmz.movies.toprated.domain.entities.TopRatedMoviesResult
import io.reactivex.Observable
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val topRatedMoviesRepo: TopRatedMoviesRepo) {
    fun getTopRatedMovies(): Observable<TopRatedMoviesResult> = topRatedMoviesRepo.getTopRatedMovies()
    fun getGenre(): Observable<GenreResult> = topRatedMoviesRepo.getGenres()
    fun saveGenresIntoDB(list: ArrayList<Genre>):Observable<Any> = topRatedMoviesRepo.saveGenres(list)
    fun getGenresFromDB() = topRatedMoviesRepo.getGenresFromDB()
}