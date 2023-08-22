package domain.repository

import data.model.BaseTMDBServiceResponse
import data.model.BaseMediaResultDTO

interface TMDBTvRepository {

    suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getPopular(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getTopRated(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getOnTheAir(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getAiringToday(): BaseTMDBServiceResponse<BaseMediaResultDTO>
}