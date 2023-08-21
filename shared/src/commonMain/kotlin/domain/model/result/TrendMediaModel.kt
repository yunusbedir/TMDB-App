package domain.model.result

data class TrendMediaModel(override val id: String, override val title: String, override val posterPath: String, override val mediaType: MediaType) :
    BaseMediaModel(id, title, posterPath, mediaType)