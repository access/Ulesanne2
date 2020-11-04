package ee.taltech.ulesanne2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ee.taltech.ulesanne2.model.CellClickListener
import ee.taltech.ulesanne2.model.Movies
import ee.taltech.ulesanne2.model.MoviesAdapter
import ee.taltech.ulesanne2.model.MoviesData
import kotlinx.android.synthetic.main.activity_movies.*


class MoviesActivity : AppCompatActivity(), CellClickListener {
    private var category: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        category = intent.getStringExtra("category")
        if (category != null) {
            val categoryMovies = Movies(MoviesData).getMoviesByCategory(category!!)
            val data = "Movies len: ${MoviesData.MOVIE_LIST.size}"
            val tmpContext = this
            recyclerView.apply {
                setHasFixedSize(true)
                adapter = MoviesAdapter(categoryMovies, tmpContext)
                layoutManager = LinearLayoutManager(this.context)
                addItemDecoration(
                    DividerItemDecoration(
                        this.context, DividerItemDecoration.VERTICAL
                    )
                )
            }
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Movies in category: $category"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
        return false
    }

    override fun onCellClickListener(position: Int, movieID: String) {
        //Toast.makeText(this, "Cell clicked: $position -> $movieID", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MovieItemActivity::class.java)
        val keyVal = arrayOf<String>(movieID, category!!)
        intent.putExtra("keyVal", keyVal)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }
}
