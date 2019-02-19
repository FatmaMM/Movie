package algorithmz.movies.data.objctes

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: Int,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("original_language")
    var originalLanguage: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("backdrop_path")
    var backdropPath: String,
    @SerializedName("vote_average")
    var voteAverage: Double,
    @SerializedName("vote_count")
    var voteCount: Int,
    @SerializedName("genre_ids")
    var genre_ids: ArrayList<Int>
)