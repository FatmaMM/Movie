package algorithmz.movies.toprated.domain.entities

import algorithmz.movies.data.objctes.Movie
import com.google.gson.annotations.SerializedName

class TopRatedMoviesResult {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    lateinit var movies: ArrayList<Movie>
}