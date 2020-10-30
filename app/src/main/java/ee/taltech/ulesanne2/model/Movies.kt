package ee.taltech.ulesanne2.model

class Movies(moviesData: MoviesData) {
    private val _moviesList = moviesData.MOVIE_LIST

    fun getMoviesByCategory(category: String): List<Movie> {
        val mlist = mutableListOf<Movie>()
        for (movie in _moviesList) {
            if (movie.Genre.contains(category)) {
                mlist.add(movie)
            }
        }
        return mlist
    }

    fun getMovieByID(movieID: String): Movie? {
        var mv: Movie? = null
        for (movie in _moviesList) {
            if (movie.imdbID == movieID) {
                return movie
            }
        }
        return mv
    }
}