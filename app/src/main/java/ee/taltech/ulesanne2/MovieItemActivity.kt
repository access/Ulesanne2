package ee.taltech.ulesanne2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import ee.taltech.ulesanne2.model.Movies
import ee.taltech.ulesanne2.model.MoviesData
import kotlinx.android.synthetic.main.activity_movie_item.*

class MovieItemActivity : AppCompatActivity() {
    private var category: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_item)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        val movieID = intent.getStringArrayExtra("keyVal")?.get(0).toString()
        category = intent.getStringArrayExtra("keyVal")?.get(1).toString()

        val movie = Movies(MoviesData).getMovieByID(movieID)

        val actionbar = supportActionBar
        actionbar!!.title = "Movie: ${movie?.Title} (${movie?.Year})"
        actionbar.setDisplayHomeAsUpEnabled(true)

        Picasso.get().load(movie?.Poster).into(im_poster)
        txt_description.text = "Description:\r\n" + movie?.Plot
        txt_Authors.text = "Writers:\r\n" + movie?.Writers.toString().replace("[", "").replace("]", "")
        txt_Title.text = movie?.Title
        txt_actors.text = "Actors:\r\n" + movie?.Actors.toString().replace("[", "").replace("]", "")
        txt_genre.text = "Genre:\r\n" + movie?.Genre.toString().replace("[", "").replace("]", "")
        txt_country.text = "Country:\r\n" + movie?.Country
        txt_lang.text = "Language:\r\n" + movie?.Language
        txt_rating.text = "Rating:\r\n" + movie?.imdbRating
        txt_year.text="Year:\r\n" +movie?.Year
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MoviesActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
        finish()
        return false
    }
}