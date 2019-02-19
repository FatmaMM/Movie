package algorithmz.movies.toprated.presentation.view

import algorithmz.movies.MovieApp
import algorithmz.movies.R
import algorithmz.movies.moviedetails.presentation.view.MovieDetailsActivity
import algorithmz.movies.toprated.domain.entities.Genre
import algorithmz.movies.toprated.presentation.adapter.MoviesAdapter
import algorithmz.movies.toprated.presentation.adapter.OnRecyclerViewItemClickListener
import algorithmz.movies.toprated.presentation.viewmodel.TopRatedMoviesVM
import algorithmz.movies.toprated.presentation.viewmodel.TopRatedMoviesVMFactory
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_top_rated.*
import javax.inject.Inject


class TopRatedActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TopRatedMoviesVMFactory

    lateinit var adapter: MoviesAdapter

    lateinit var moviesVM: TopRatedMoviesVM

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_rated)

        MovieApp.get(this).setUpTopRatedActivityComponent()!!.inject(this)

        moviesVM = ViewModelProviders.of(this, factory).get(TopRatedMoviesVM::class.java)
        adapter = MoviesAdapter()

        adapter.onRecyclerViewItemClickListener = object : OnRecyclerViewItemClickListener {
            override fun onClick(movieId: Int) {
                val intent = Intent(this@TopRatedActivity, MovieDetailsActivity::class.java)
                intent.putExtra("id", movieId)
                startActivity(intent)
            }
        }
        moviesVM.moviesLiveData.observe(this, Observer {
            it?.let {
                intiViews()
                adapter.movies = it
            }
        })

        moviesVM.errorState.observe(this, Observer {
            showError(it)
        })

        moviesVM.loadState.observe(this, Observer {
            if (it!!)
                progressbar.visibility = View.GONE
        })

        moviesVM.genresLiveData.observe(this, Observer {
            if (it == null || it!!.isEmpty())
                moviesVM.getGenres()
            else {
                adapter.genres = (it as ArrayList<Genre>)
                moviesVM.getTopRatedMovies()
            }
        })
        moviesVM.getGenresFromDB()
    }

    private fun intiViews() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            movies_recyclerView.layoutManager = GridLayoutManager(this, 3)
        } else {
            movies_recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        movies_recyclerView.adapter = adapter
    }


    private fun showError(it: Throwable?) {
        movies_recyclerView.visibility = View.GONE
        progressbar.visibility = View.GONE

        it?.let {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        MovieApp.get(this).deleteTopRatedComponent()
    }
}
