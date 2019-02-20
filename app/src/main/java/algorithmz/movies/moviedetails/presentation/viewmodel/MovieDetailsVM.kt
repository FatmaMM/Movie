package algorithmz.movies.moviedetails.presentation.viewmodel

import algorithmz.movies.moviedetails.domain.entities.Movie
import algorithmz.movies.moviedetails.domain.entities.Trailer
import algorithmz.movies.moviedetails.domain.entities.TrailerResponse
import algorithmz.movies.moviedetails.domain.interactors.GetMovieDetailsUseCase
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailsVM @Inject constructor(private val movieDetailsUseCase: GetMovieDetailsUseCase) : ViewModel() {
    var errorState: MutableLiveData<Throwable> = MutableLiveData()
    var moviesLiveData: MutableLiveData<Movie> = MutableLiveData()
    var tarilsLiveData: MutableLiveData<ArrayList<Trailer>> = MutableLiveData()

    fun getMovieData(movieId: Int) {
        movieDetailsUseCase.getMovieDetails(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribe(object : SingleObserver<Movie> {
                override fun onSuccess(t: Movie) {
                        moviesLiveData.value = t
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    errorState.value = e
                }
            })
    }

    fun getTrailers(id: Int) {
        movieDetailsUseCase.getTrailers(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribe(object : Observer<TrailerResponse> {
                override fun onComplete() {

                }

                override fun onNext(t: TrailerResponse) {
                    tarilsLiveData.value = t.getResults()
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    errorState.value = e
                }

            })
    }
}

