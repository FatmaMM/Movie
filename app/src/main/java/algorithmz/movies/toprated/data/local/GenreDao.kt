package algorithmz.movies.toprated.data.local

import algorithmz.movies.toprated.domain.entities.Genre
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface GenreDao {
    @Insert
    fun insertGenre(genre: List<Genre>)

    @Query("SELECT * FROM genre")
    fun getAllGenres(): Flowable<List<Genre>>
}