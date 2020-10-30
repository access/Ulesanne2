package ee.taltech.ulesanne2.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ee.taltech.ulesanne2.R
import kotlinx.android.synthetic.main.item_layout.view.*


class MoviesAdapter(val list: List<Movie>, private val cellClickListener: CellClickListener) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent, false
        )
        return MovieViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = list[position]
        Picasso.get().load(currentMovie.Poster).into(holder.poster)
        holder.title.text = currentMovie.Title + " (${currentMovie.Year})"
        holder.country.text = currentMovie.Country
        holder.rating.text = currentMovie.imdbRating.toString()

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(position, currentMovie.imdbID)
        }
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val poster: ImageView = itemView.iv_icon
    val title: TextView = itemView.tv_icon
    val country: TextView = itemView.tv_country
    val rating: TextView = itemView.tv_rating
}

