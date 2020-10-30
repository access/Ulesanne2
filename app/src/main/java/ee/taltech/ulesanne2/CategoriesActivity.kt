package ee.taltech.ulesanne2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ee.taltech.ulesanne2.model.CategoriesAdapter
import ee.taltech.ulesanne2.model.CategoryDataClass
import ee.taltech.ulesanne2.model.MoviesData

class CategoriesActivity : AppCompatActivity() {
    private lateinit var categoryList: ArrayList<CategoryDataClass>
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        setTitle("Movie categories");

        val movieData: MoviesData
        val arguments = intent.extras
        if (arguments != null) {
            movieData = arguments.getSerializable(MoviesData::class.simpleName) as MoviesData

            categoryList = ArrayList<CategoryDataClass>()
            for ((i, category) in movieData.CATEGORY_LIST.withIndex()) {
                categoryList.add(CategoryDataClass(i, category))
            }

            listView = findViewById<ListView>(R.id.recipe_list_view)
            val listItems = arrayOfNulls<String>(movieData.CATEGORY_LIST.size)
            for (i in 0 until movieData.CATEGORY_LIST.size) {
                val recipe = movieData.CATEGORY_LIST.elementAt(i)
                listItems[i] = recipe
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
            listView.adapter = adapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, MoviesActivity::class.java)
                intent.putExtra("category", listItems.elementAt(position))
                startActivity(intent)
                finish()
            }
        }
    }
}