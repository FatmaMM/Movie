package algorithmz.movies.moviedetails.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class MovieDetailsVMFactory @Inject constructor(private val movieDetailsVM: MovieDetailsVM) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return movieDetailsVM as T
    }
}