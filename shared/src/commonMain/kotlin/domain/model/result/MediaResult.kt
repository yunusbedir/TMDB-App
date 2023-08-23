package domain.model.result

data class MediaResult(
    override val id: String,
    override val title: String,
    override val posterPath: String,
    override val backdropPath: String,
    override val mediaType: MediaType,
    override val overview: String
) :
    BaseMediaModel(id, title, posterPath, backdropPath, mediaType, overview)