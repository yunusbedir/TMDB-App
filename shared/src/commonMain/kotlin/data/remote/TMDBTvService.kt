package data.remote

import data.model.BaseTMDBServiceResponse
import data.model.BaseMediaResultDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TMDBTvService(private val httpClient: HttpClient, private val baseUrl: String) {
    private val apiKey = "2fd7b5cc824fc9ba532f207ad3da4908"

    suspend fun getTrendingOfDay(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        httpClient.get("$baseUrl/trending/tv/day?language=$language&api_key=$apiKey").body()

    suspend fun getPopular(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        httpClient.get("$baseUrl/tv/popular?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getTopRated(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        httpClient.get("$baseUrl/tv/top_rated?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getOnTheAir(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        httpClient.get("$baseUrl/tv/on_the_air?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getAiringToday(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        httpClient.get("$baseUrl/tv/airing_today?language=$language&page=$page&api_key=$apiKey").body()
}
