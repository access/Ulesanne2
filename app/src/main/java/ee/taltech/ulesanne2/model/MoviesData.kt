package ee.taltech.ulesanne2.model

import java.io.Serializable

object MoviesData : Serializable {
    var MOVIE_LIST: List<Movie> = mutableListOf<Movie>()
    var CATEGORY_LIST: MutableSet<String> = mutableSetOf<String>()
}