package domain.usecase

import data.model.MovieMediaResultDTO
import data.model.BaseTMDBServiceResponse
import data.model.TvMediaResultDTO
import domain.UseCaseState
import domain.model.result.BaseMediaModel
import domain.model.result.MediaResult
import domain.model.result.MediaType
import domain.repository.TMDBTvRepository
import kotlinx.coroutines.flow.flow

class GetTvSeriesUseCase(
    private val tmdbTvRepository: TMDBTvRepository
) {

    operator fun invoke() = flow {
        try {
            val trendsOfDay = tmdbTvRepository.getTrendingOfDay()
            val popular = tmdbTvRepository.getPopular()
            val topRated = tmdbTvRepository.getTopRated()
            val onTheAir = tmdbTvRepository.getOnTheAir()
            val airingToday = tmdbTvRepository.getAiringToday()
            emit(
                UseCaseState.Success(
                    TvSeriesUseCaseModel(
                        trendsOfDay = trendsOfDay.convertToResult(),
                        popular = popular.convertToResult(),
                        topRated = topRated.convertToResult(),
                        onTheAir = onTheAir.convertToResult(),
                        airingToday = airingToday.convertToResult()
                    )
                )
            )
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }

    companion object {
        private fun BaseTMDBServiceResponse<TvMediaResultDTO>.convertToResult(): List<MediaResult> {
            return results?.map {
                MediaResult(
                    id = it.id.toString(),
                    title = it.name.toString(),
                    posterPath = "https://image.tmdb.org/t/p/original/" + it.poster_path.toString(),
                    backdropPath = "https://image.tmdb.org/t/p/original/" + it.backdrop_path.toString(),
                    mediaType = MediaType.getMediaType(it.media_type.toString()),
                    overview = it.overview.toString()
                )
            }.orEmpty()
        }
    }
}

data class TvSeriesUseCaseModel(
    val trendsOfDay: List<BaseMediaModel> = listOf(),
    val popular: List<BaseMediaModel> = listOf(),
    val topRated: List<BaseMediaModel> = listOf(),
    val onTheAir: List<BaseMediaModel> = listOf(),
    val airingToday: List<BaseMediaModel> = listOf(),
)