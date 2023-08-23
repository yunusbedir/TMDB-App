package data.repository

import data.model.BaseTMDBServiceResponse
import data.model.MovieMediaResultDTO
import data.remote.TMDBMovieService
import domain.repository.TMDBMovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import tMDBDispatchers

class TMDBMovieRepositoryImpl(
    private val tMDBMovieService: TMDBMovieService,
    private val coroutineDispatcher: CoroutineDispatcher = tMDBDispatchers.io
) : TMDBMovieRepository {

    override suspend fun getTrendingOfDay(): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getTrendingOfDay()
        }

    override suspend fun getPopular(): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getPopular()
        }

    override suspend fun getTopRated(): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getTopRated()
        }

    override suspend fun getNowPlaying(): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getNowPlaying()
        }

    override suspend fun getUpComing(): BaseTMDBServiceResponse<MovieMediaResultDTO> =
        withContext(coroutineDispatcher) {
            tMDBMovieService.getUpComing()
        }
}