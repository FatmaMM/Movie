package algorithmz.movies.moviedetails.presentation.view.adapter

import algorithmz.movies.R
import algorithmz.movies.moviedetails.domain.entities.Trailer
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TrailerAdapter : RecyclerView.Adapter<TrailerAdapter.mViewHolder>() {

    lateinit var trailers: List<Trailer>
    lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trailer, parent, false)
        return mViewHolder(view)
    }

    /**
     * Bind a View that displays the data at the specified position in the data set.
     *
     * @param position The position of the item within the adapter's data set of the item whose view we want.
     * @param holder   view to reuse, if possible.
     */
    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        holder.mItem = trailers[position]
        holder.textView!!.text = holder.mItem!!.name
    }

    override fun getItemCount(): Int {
        return trailers.size
    }

    inner class mViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /**
         * Defines cast recycler view row elements.
         */
        var mItem: Trailer? = null

        var textView: TextView? = itemView.findViewById(R.id.tr_name)

        init {
            //open trailers with youtube
            itemView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + mItem!!.key))
                intent.putExtra("video_id", mItem!!.key)
                context.startActivity(intent)
            }
        }
    }
}
