package data.repository

import data.model.BaseTMDBServiceResponse
import data.model.TrendMediaResultDTO
import data.remote.TMDBService
import domain.repository.TMDBServiceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tMDBDispatchers

class TMDBServiceRepositoryImpl(
    private val tMDBService: TMDBService,
    private val coroutineDispatcher: CoroutineDispatcher = tMDBDispatchers.io
) : TMDBServiceRepository {

    override suspend fun getTrendingAllOfDay(): BaseTMDBServiceResponse<TrendMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBService.getTrendingAllOfDay()
        }
}