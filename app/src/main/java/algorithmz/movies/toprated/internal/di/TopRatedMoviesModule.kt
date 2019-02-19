package algorithmz.movies.toprated.internal.di

import algorithmz.movies.toprated.data.local.AppDataBase
import algorithmz.movies.toprated.data.remoterepository.TopRatedMoviesAPI
import algorithmz.movies.toprated.data.remoterepository.TopRatedMoviesRepoImplementation
import algorithmz.movies.toprated.domain.datarepository.TopRatedMoviesRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TopRatedMoviesModule {
    @Provides
    fun providesTopRatedMoviesAPI(retrofit: Retrofit) = retrofit.create(TopRatedMoviesAPI::class.java)!!

    @Provides
    fun providesTopRatedMoviesAPIRepo(api: TopRatedMoviesAPI, appDataBase: AppDataBase): TopRatedMoviesRepo =
        TopRatedMoviesRepoImplementation(api, appDataBase)

}