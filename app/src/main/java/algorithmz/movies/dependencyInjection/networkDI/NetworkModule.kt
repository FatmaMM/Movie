package algorithmz.movies.dependencyInjection.networkDI

import algorithmz.movies.BuildConfig.BASE_URL
import algorithmz.movies.BuildConfig.THE_MOVIE_API_KEY
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", THE_MOVIE_API_KEY)
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)
        }

        //okHttpClint to establish the connection
        val client = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(interceptor)
            .build()

        //retrofit library to connect with server its like volley
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }
}