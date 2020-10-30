package ee.taltech.ulesanne2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import com.google.gson.*
import ee.taltech.ulesanne2.model.Movie
import ee.taltech.ulesanne2.model.MoviesData

import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "movies.json")
        val gsonArray = Gson()
        val movieList: List<Movie> = gsonArray.fromJson(jsonFileString, Array<Movie>::class.java).toList()
        val categoriesSet = mutableSetOf<String>()
        movieList.map { el -> el.Genre }.forEach { it.forEach { categoriesSet.add(it) } };

        val md = MoviesData
        md.MOVIE_LIST = movieList
        md.CATEGORY_LIST = categoriesSet

        if (movieList.size > 0) {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.putExtra(MoviesData::class.simpleName, md)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "No movies JSON data", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}