package domain.usecase

import data.model.BaseMediaResultDTO
import data.model.BaseTMDBServiceResponse
import domain.UseCaseState
import domain.model.result.BaseMediaModel
import domain.model.result.MediaResult
import domain.model.result.MediaType
import domain.repository.TMDBMovieRepository
import kotlinx.coroutines.flow.flow

class GetMoviesUseCase(
    private val tmdbMovieRepository: TMDBMovieRepository
) {

    operator fun invoke() = flow {
        try {
            val trendsOfDay = tmdbMovieRepository.getTrendingOfDay()
            val popular = tmdbMovieRepository.getPopular()
            val topRated = tmdbMovieRepository.getTopRated()
            val nowPlaying = tmdbMovieRepository.getNowPlaying()
            val upComing = tmdbMovieRepository.getUpComing()
            emit(
                UseCaseState.Success(
                    MoviesUseCaseModel(
                        trendsOfDay = trendsOfDay.convertToResult(),
                        popular = popular.convertToResult(),
                        topRated = topRated.convertToResult(),
                        nowPlaying = nowPlaying.convertToResult(),
                        upComing = upComing.convertToResult()
                    )
                )
            )
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }

    companion object {
        private fun BaseTMDBServiceResponse<BaseMediaResultDTO>.convertToResult(): List<MediaResult> {
            return results?.map {
                MediaResult(
                    id = it.id.toString(),
                    title = it.title.toString(),
                    posterPath = "https://image.tmdb.org/t/p/original/" + it.poster_path.toString(),
                    backdropPath = "https://image.tmdb.org/t/p/original/" + it.backdrop_path.toString(),
                    mediaType = MediaType.getMediaType(it.media_type.toString())
                )
            }.orEmpty()
        }
    }
}

data class MoviesUseCaseModel(
    val trendsOfDay: List<BaseMediaModel> = listOf(),
    val popular: List<BaseMediaModel> = listOf(),
    val topRated: List<BaseMediaModel> = listOf(),
    val nowPlaying: List<BaseMediaModel> = listOf(),
    val upComing: List<BaseMediaModel> = listOf(),
)