package algorithmz.movies.toprated.data.remoterepository

import algorithmz.movies.toprated.domain.entities.GenreResult
import algorithmz.movies.toprated.domain.entities.TopRatedMoviesResult
import io.reactivex.Observable
import retrofit2.http.GET

interface TopRatedMoviesAPI {
    @GET("movie/top_rated")
    fun getTopRatedMovies(): Observable<TopRatedMoviesResult>

    @GET("genre/movie/list")
    fun getGenres(): Observable<GenreResult>
}