package algorithmz.movies.toprated.data.local

import algorithmz.movies.toprated.domain.entities.Genre
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(entities = [Genre::class], version = 1)
abstract class AppDataBase :RoomDatabase(){
    abstract fun genreDao(): GenreDao
}