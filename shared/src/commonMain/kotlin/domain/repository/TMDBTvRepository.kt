package domain.repository

import data.model.BaseTMDBServiceResponse
import data.model.TvMediaResultDTO

interface TMDBTvRepository {

    suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<TvMediaResultDTO>
    suspend fun getPopular(): BaseTMDBServiceResponse<TvMediaResultDTO>
    suspend fun getTopRated(): BaseTMDBServiceResponse<TvMediaResultDTO>
    suspend fun getOnTheAir(): BaseTMDBServiceResponse<TvMediaResultDTO>
    suspend fun getAiringToday(): BaseTMDBServiceResponse<TvMediaResultDTO>
}