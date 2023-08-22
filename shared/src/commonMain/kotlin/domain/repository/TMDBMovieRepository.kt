package domain.repository

import data.model.BaseTMDBServiceResponse
import data.model.BaseMediaResultDTO

interface TMDBMovieRepository {

    suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getPopular(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getTopRated(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getNowPlaying(): BaseTMDBServiceResponse<BaseMediaResultDTO>
    suspend fun getUpComing(): BaseTMDBServiceResponse<BaseMediaResultDTO>
}