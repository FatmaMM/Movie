package algorithmz.movies.toprated.domain.entities

import com.google.gson.annotations.SerializedName

class TopRatedMoviesResult {
    @SerializedName("page")
    var page: Int = 0
    @SerializedName("results")
    lateinit var movies: ArrayList<Movie>
}