package data.repository

import data.model.BaseTMDBServiceResponse
import data.model.BaseMediaResultDTO
import data.remote.TMDBTvService
import domain.repository.TMDBTvRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tMDBDispatchers

class TMDBTvRepositoryImpl(
    private val tMDBTvService: TMDBTvService,
    private val coroutineDispatcher: CoroutineDispatcher = tMDBDispatchers.io
) : TMDBTvRepository {

    override suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getTrendingOfDay()
        }

    override suspend fun getPopular(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getPopular()
        }

    override suspend fun getTopRated(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getTopRated()
        }

    override suspend fun getOnTheAir(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getOnTheAir()
        }

    override suspend fun getAiringToday(): BaseTMDBServiceResponse<BaseMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBTvService.getAiringToday()
        }
}