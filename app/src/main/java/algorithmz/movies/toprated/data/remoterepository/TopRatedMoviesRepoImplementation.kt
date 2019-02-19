package algorithmz.movies.toprated.data.remoterepository

import algorithmz.movies.toprated.data.local.AppDataBase
import algorithmz.movies.toprated.domain.datarepository.TopRatedMoviesRepo
import algorithmz.movies.toprated.domain.entities.Genre
import algorithmz.movies.toprated.domain.entities.GenreResult
import algorithmz.movies.toprated.domain.entities.TopRatedMoviesResult
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class TopRatedMoviesRepoImplementation @Inject constructor(
    private val topRatedMoviesAPI: TopRatedMoviesAPI,
    private val db: AppDataBase) : TopRatedMoviesRepo {
    override fun saveGenres(list: ArrayList<Genre>): Observable<Any> {
        return Observable.fromCallable { db.genreDao().insertGenre(list) }
    }

    override fun getTopRatedMovies(): Observable<TopRatedMoviesResult> = topRatedMoviesAPI.getTopRatedMovies()
    override fun getGenres(): Observable<GenreResult> = topRatedMoviesAPI.getGenres()
    override fun getGenresFromDB(): Flowable<List<Genre>> = db.genreDao().getAllGenres()
}