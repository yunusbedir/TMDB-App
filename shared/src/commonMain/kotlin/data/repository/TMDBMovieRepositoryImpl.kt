package data.repository

import data.model.BaseTMDBServiceResponse
import data.model.BaseMediaResultDTO
import data.remote.TMDBMovieService
import domain.repository.TMDBMovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tMDBDispatchers

class TMDBMovieRepositoryImpl(
    private val tMDBMovieService: TMDBMovieService,
    private val coroutineDispatcher: CoroutineDispatcher = tMDBDispatchers.io
) : TMDBMovieRepository {

    override suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getTrendingOfDay()
        }

    override suspend fun getPopular(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getPopular()
        }

    override suspend fun getTopRated(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getTopRated()
        }

    override suspend fun getNowPlaying(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getNowPlaying()
        }

    override suspend fun getUpComing(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getUpComing()
        }
}