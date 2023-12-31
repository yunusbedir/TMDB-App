package domain.model.result

open class BaseMediaModel(
    open val id: String,
    open val title: String,
    open val posterPath: String,
    open val backdropPath: String,
    open val mediaType: MediaType,
    open val overview: String
)

enum class MediaType(val value: String) {
    TV("tv"), MOVIE("movie");

    companion object {
        fun getMediaType(value: String): MediaType {
            return when (value) {
                TV.value -> TV
                MOVIE.value -> MOVIE
                else -> MOVIE
            }
        }
    }
}