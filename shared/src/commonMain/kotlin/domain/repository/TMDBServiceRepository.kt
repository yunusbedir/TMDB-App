package domain.repository

import data.model.BaseTMDBServiceResponse
import data.model.TrendMediaResultDTO

interface TMDBServiceRepository {

    suspend fun getTrendingAllOfDay(): BaseTMDBServiceResponse<TrendMediaResultDTO>
}