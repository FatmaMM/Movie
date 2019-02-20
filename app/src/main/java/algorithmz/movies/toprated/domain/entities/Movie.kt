package algorithmz.movies.toprated.domain.entities

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("genre_ids")
        var genre_ids: ArrayList<Int>,
        @SerializedName("poster_path")
        var posterPath: String
        )