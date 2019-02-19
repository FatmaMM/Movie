package algorithmz.movies.dependencyInjection.appDI

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
class AppModule constructor(application: Application) {
    private val application = application
    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }
}