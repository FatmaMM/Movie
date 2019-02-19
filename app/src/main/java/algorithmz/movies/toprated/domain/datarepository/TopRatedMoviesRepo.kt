package algorithmz.movies.toprated.domain.datarepository

import algorithmz.movies.toprated.domain.entities.Genre
import algorithmz.movies.toprated.domain.entities.GenreResult
import algorithmz.movies.toprated.domain.entities.TopRatedMoviesResult
import io.reactivex.Flowable
import io.reactivex.Observable

interface TopRatedMoviesRepo {
    fun getTopRatedMovies(): Observable<TopRatedMoviesResult>
    fun getGenres(): Observable<GenreResult>
    fun saveGenres(list: ArrayList<Genre>):Observable<Any>
    fun getGenresFromDB(): Flowable<List<Genre>>
}