package ee.taltech.ulesanne2.model

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Movie(
    val Title: String,
    val Year: Int,
    val Rated: String,
    val Released: String,
    val Runtime: String,
    val Genre: List<String>,
    val Director: String,
    val Writers: List<String>,
    val Actors: List<String>,
    val Plot: String,
    val Language: String,
    val Country: String,
    val Awards: String,
    val Poster: String,
    val imdbRating: Double,
    val imdbVotes: String,
    val imdbID: String

) {
    override fun toString(): String {
        return "Title: ${Title}\r\n" +
                "Year: ${Year}\r\n" +
                "Released: ${Released}\r\n" +
                "Genre: ${Genre}\r\n" +
                "Director: ${Director}\r\n" +
                "Writers: ${Writers}\r\n" +
                "Actors: ${Actors}\r\n" +
                "Language: ${Language}\r\n" +
                "Country: $Country\r\n" +
                "Plot: $Plot"
    }

}
