package algorithmz.movies.moviedetails.data.repository

import algorithmz.movies.moviedetails.domain.entities.Movie
import algorithmz.movies.moviedetails.domain.entities.TrailerResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsAPI {
    @GET("movie/{id}?")
    fun getMovieDetails(@Path("id") id: Int): Single<Movie>

    @GET("movie/{movie_id}/videos")
     fun getMovieTrailers(@Path("movie_id") id: Int): Observable<TrailerResponse>
}