package algorithmz.movies.toprated.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class TopRatedMoviesVMFactory @Inject constructor(private val topRatedMoviesVM: TopRatedMoviesVM) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return topRatedMoviesVM as T
    }
}