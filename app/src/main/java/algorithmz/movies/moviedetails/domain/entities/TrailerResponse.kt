package algorithmz.movies.moviedetails.domain.entities

import com.google.gson.annotations.SerializedName

class TrailerResponse {
    @SerializedName("id")
    private val id_trailer: Int = 0
    @SerializedName("results")
    private val results: ArrayList<Trailer>? = null

    fun getId_trailer(): Int {
        return id_trailer
    }

    fun getResults(): ArrayList<Trailer>? {
        return results
    }
}