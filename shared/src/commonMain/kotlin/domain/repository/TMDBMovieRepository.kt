package domain.repository

import data.model.BaseTMDBServiceResponse
import data.model.MovieMediaResultDTO

interface TMDBMovieRepository {

    suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<MovieMediaResultDTO>
    suspend fun getPopular(): BaseTMDBServiceResponse<MovieMediaResultDTO>
    suspend fun getTopRated(): BaseTMDBServiceResponse<MovieMediaResultDTO>
    suspend fun getNowPlaying(): BaseTMDBServiceResponse<MovieMediaResultDTO>
    suspend fun getUpComing(): BaseTMDBServiceResponse<MovieMediaResultDTO>
}