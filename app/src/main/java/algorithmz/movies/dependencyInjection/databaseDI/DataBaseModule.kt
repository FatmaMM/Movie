package algorithmz.movies.dependencyInjection.databaseDI

import algorithmz.movies.toprated.data.local.AppDataBase
import algorithmz.movies.toprated.internal.di.TopRatedActivityScope
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {
    @Provides
    fun provideAppDataBase(@TopRatedActivityScope context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "genredb").build()
    }
}