package algorithmz.movies.toprated.presentation.viewmodel

import algorithmz.movies.data.objctes.Movie
import algorithmz.movies.toprated.domain.entities.Genre
import algorithmz.movies.toprated.domain.entities.GenreResult
import algorithmz.movies.toprated.domain.entities.TopRatedMoviesResult
import algorithmz.movies.toprated.domain.interactor.GetTopRatedMoviesUseCase
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class TopRatedMoviesVM @Inject constructor(private val topRatedMoviesUseCase: GetTopRatedMoviesUseCase) : ViewModel() {
    var errorState: MutableLiveData<Throwable> = MutableLiveData()
    var moviesLiveData: MutableLiveData<ArrayList<Movie>> = MutableLiveData()
    var genresLiveData: MutableLiveData<List<Genre>> = MutableLiveData()
    var loadState: MutableLiveData<Boolean> = MutableLiveData()

    fun getTopRatedMovies() {
        topRatedMoviesUseCase.getTopRatedMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribe(object : Observer<TopRatedMoviesResult> {
                override fun onComplete() {
                    loadState.value = true
                }

                override fun onNext(t: TopRatedMoviesResult) {
                    moviesLiveData.value = t.movies
                }

                override fun onSubscribe(d: Disposable) {
                    loadState.value = false
                }

                override fun onError(e: Throwable) {
                    errorState.value = e
                }
            })
    }

    fun getGenres() {
        topRatedMoviesUseCase.getGenre()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribe(object : Observer<GenreResult> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: GenreResult) {
                    saveGenres(t.geners)
                }

                override fun onError(e: Throwable) {
                    errorState.value = e
                }

            })
    }

    fun saveGenres(list: ArrayList<Genre>) {
        topRatedMoviesUseCase.saveGenresIntoDB(list).subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Any>{
                override fun onComplete() {
                    Log.d("Save into data bas:","Done")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("Save into data bas:","Start")
                }

                override fun onNext(t: Any) {
                    Log.d("Save into data bas:","Continue...")
                }

                override fun onError(e: Throwable) {
                    Log.d("Save into data bas:",e.message)
                }
            })
    }

    fun getGenresFromDB() {
        topRatedMoviesUseCase.getGenresFromDB()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .toObservable()
            .subscribe(object : Observer<List<Genre>> {
                override fun onComplete() {
                }

                override fun onNext(t: List<Genre>) {
                    genresLiveData.value = t
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    errorState.value = e
                }

            })
    }

}