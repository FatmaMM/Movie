package algorithmz.movies.moviedetails.presentation.view

import algorithmz.movies.BuildConfig
import algorithmz.movies.MovieApp
import algorithmz.movies.R
import algorithmz.movies.data.objctes.Movie
import algorithmz.movies.moviedetails.domain.entities.Trailer
import algorithmz.movies.moviedetails.presentation.view.adapter.TrailerAdapter
import algorithmz.movies.moviedetails.presentation.viewmodel.MovieDetailsVM
import algorithmz.movies.moviedetails.presentation.viewmodel.MovieDetailsVMFactory
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_moredata.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieDetailsVMFactory

    lateinit var movieVM: MovieDetailsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        MovieApp.get(this).setUpMoviesActivityComponent()!!.inject(this)
        movieVM = ViewModelProviders.of(this, factory).get(MovieDetailsVM::class.java)

        movieVM.errorState.observe(this, Observer { showError(it) })
        movieVM.moviesLiveData.observe(this, Observer { display(it) })
        movieVM.tarilsLiveData.observe(this, Observer { displayTrailer(it) })

        movieVM.getTrailers(intent!!.getIntExtra("id",0))
        movieVM.getMovieData(intent!!.getIntExtra("id",0))
    }

    override fun onDestroy() {
        super.onDestroy()
        MovieApp.get(this).deletMovieComponent()
    }

    private fun displayTrailer(it: ArrayList<Trailer>?) {
        var adapter = TrailerAdapter()
        adapter.context = this
        adapter.trailers = it!!
        trailers.layoutManager = LinearLayoutManager(this)
        trailers.adapter = adapter

    }

    private fun display(it: Movie?) {
        it?.let {
            Glide.with(this).load(BuildConfig.IMG_BASE_URL + it.backdropPath).into(movieImage)
            rate.text = it.voteAverage.toString()
            year.text = it.releaseDate
            lang.text = it.originalLanguage
            overView.text = it.overview
            toolbar_layout.title = it.title
            tabs.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    if (tab.text!!.toString().equals(getString(R.string.overView), ignoreCase = true)) {
                        overView.visibility = View.VISIBLE
                        trailers.visibility = View.GONE
                    } else {
                        overView.visibility = View.GONE
                        trailers.visibility = View.VISIBLE
                        trailers.layoutManager = LinearLayoutManager(this@MovieDetailsActivity)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
        }

    }

    private fun showError(it: Throwable?) {
        it?.let {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }
    }
}
