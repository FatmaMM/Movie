package algorithmz.movies.toprated.presentation.adapter

import algorithmz.movies.BuildConfig
import algorithmz.movies.R
import algorithmz.movies.data.objctes.Movie
import algorithmz.movies.toprated.domain.entities.Genre
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    var movies: MutableList<Movie> = mutableListOf()
    var genres: MutableList<Genre> = mutableListOf()

    lateinit var onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MovieViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_movie, p0, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        var s = StringBuilder()

        for (i in 0 until movie.genre_ids.size) {
            for (j in genres.indices)
                if (movie.genre_ids[i] == genres[j].id) {
                    s.append(genres[j].name + " ,")
                }
        }

        holder.genre.text = s.toString()
        holder.name.text = movie.title
        Glide.with(holder.itemView.context)
            .load(BuildConfig.IMG_BASE_URL + movie.posterPath)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
                onRecyclerViewItemClickListener.onClick(movie.id)
        }
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * Defines cast recycler view row elements.
         */
        var imageView: ImageView = itemView.findViewById(R.id.item_image)
        var name: TextView = itemView.findViewById(R.id.movie_item_name)
        var genre: TextView = itemView.findViewById(R.id.item_genre)

    }
}