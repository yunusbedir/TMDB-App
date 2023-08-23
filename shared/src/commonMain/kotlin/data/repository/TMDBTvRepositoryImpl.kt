package data.repository

import data.model.BaseTMDBServiceResponse
import data.model.TvMediaResultDTO
import data.remote.TMDBTvService
import domain.repository.TMDBTvRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tMDBDispatchers

class TMDBTvRepositoryImpl(
    private val tMDBTvService: TMDBTvService,
    private val coroutineDispatcher: CoroutineDispatcher = tMDBDispatchers.io
) : TMDBTvRepository {

    override suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<TvMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getTrendingOfDay()
        }

    override suspend fun getPopular(): BaseTMDBServiceResponse<TvMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getPopular()
        }

    override suspend fun getTopRated(): BaseTMDBServiceResponse<TvMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getTopRated()
        }

    override suspend fun getOnTheAir(): BaseTMDBServiceResponse<TvMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getOnTheAir()
        }

    override suspend fun getAiringToday(): BaseTMDBServiceResponse<TvMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getAiringToday()
        }
}