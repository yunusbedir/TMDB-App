package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BaseMediaResultDTO(
    @SerialName("adult")
    val adult: Boolean? = null,
    @SerialName("backdrop_path")
    val backdrop_path: String? = null,
    @SerialName("first_air_date")
    val first_air_date: String? = null,
    @SerialName("genre_ids")
    val genre_ids: List<Int>? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("media_type")
    val media_type: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("origin_country")
    val origin_country: List<String>? = null,
    @SerialName("original_language")
    val original_language: String? = null,
    @SerialName("original_name")
    val original_name: String? = null,
    @SerialName("original_title")
    val original_title: String? = null,
    @SerialName("overview")
    val overview: String? = null,
    @SerialName("popularity")
    val popularity: Double? = null,
    @SerialName("poster_path")
    val poster_path: String? = null,
    @SerialName("release_date")
    val release_date: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("video")
    val video: Boolean? = null,
    @SerialName("vote_average")
    val vote_average: Double? = null,
    @SerialName("vote_count")
    val vote_count: Int? = null
)