package algorithmz.movies.toprated.domain.entities

import com.google.gson.annotations.SerializedName

class GenreResult {
    @SerializedName("genres")
    lateinit var geners: ArrayList<Genre>
}