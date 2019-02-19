package algorithmz.movies.toprated.domain.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genre")
class Genre {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0

    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = ""
}