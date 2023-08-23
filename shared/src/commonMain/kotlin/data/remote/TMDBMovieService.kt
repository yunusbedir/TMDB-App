package data.remote

import data.model.BaseTMDBServiceResponse
import data.model.MovieMediaResultDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TMDBMovieService(private val httpClient: HttpClient, private val baseUrl: String) {
    private val apiKey = "2fd7b5cc824fc9ba532f207ad3da4908"

    suspend fun getTrendingOfDay(
        language: String = "en-US"
    ): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        httpClient.get("$baseUrl/trending/movie/day?language=$language&api_key=$apiKey").body()

    suspend fun getPopular(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        httpClient.get("$baseUrl/movie/popular?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getTopRated(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        httpClient.get("$baseUrl/movie/top_rated?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getNowPlaying(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        httpClient.get("$baseUrl/movie/now_playing?language=$language&page=$page&api_key=$apiKey").body()

    suspend fun getUpComing(
        language: String = "en-US",
        page: Int = 1
    ): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        httpClient.get("$baseUrl/movie/upcoming?language=$language&page=$page&api_key=$apiKey").body()
}
