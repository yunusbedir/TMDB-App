package domain.model.result

open class BaseMediaModel(
    open val id: String,
    open val title: String,
    open val posterPath: String,
    open val mediaType: MediaType
)

enum class MediaType(val value: String) {
    TV("tv"), MOVIE("movie")
}