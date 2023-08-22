package data.remote

import data.model.BaseTMDBServiceResponse
import data.model.TrendMediaResultDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TMDBService(private val httpClient: HttpClient, private val baseUrl: String) {
    private val apiKey = "2fd7b5cc824fc9ba532f207ad3da4908"

    suspend fun getTrendingAllOfDay(): BaseTMDBServiceResponse<TrendMediaResultDTO> =
        httpClient.get("$baseUrl/trending/all/day?language=en-US&api_key=$apiKey").body()
}
