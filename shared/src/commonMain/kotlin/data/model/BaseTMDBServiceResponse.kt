package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BaseTMDBServiceResponse<T>(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<T>? = null,
    @SerialName("total_pages")
    val total_pages: Int? = null,
    @SerialName("total_results")
    val total_results: Int? = null
)