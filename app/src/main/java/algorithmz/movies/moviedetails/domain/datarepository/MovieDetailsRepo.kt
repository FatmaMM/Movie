package algorithmz.movies.moviedetails.domain.datarepository

import algorithmz.movies.moviedetails.domain.entities.Movie
import algorithmz.movies.moviedetails.domain.entities.TrailerResponse
import io.reactivex.Observable
import io.reactivex.Single

interface MovieDetailsRepo {
    fun getMovie(id:Int):Single<Movie>
    fun getTrailers(id: Int):Observable<TrailerResponse>
}