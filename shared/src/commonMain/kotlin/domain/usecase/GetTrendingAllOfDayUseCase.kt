package domain.usecase

import data.model.BaseTMDBServiceResponse
import data.model.TrendMediaResultDTO
import domain.UseCaseState
import domain.model.result.MediaType
import domain.model.result.TrendMediaModel
import domain.repository.TMDBServiceRepository
import kotlinx.coroutines.flow.flow

class GetTrendingAllOfDayUseCase(
    private val tmdbServiceRepository: TMDBServiceRepository
) {

    operator fun invoke() = flow {
        try {
            val response = tmdbServiceRepository.getTrendingAllOfDay()
            val result = response.convertToResult()
            emit(UseCaseState.Success(result))
        } catch (e: Exception) {
            emit(UseCaseState.Error(e.message.toString()))
        }
    }

    companion object {

        fun BaseTMDBServiceResponse<TrendMediaResultDTO>.convertToResult(): List<TrendMediaModel> {
            return results?.map {
                TrendMediaModel(
                    id = it.id.toString(),
                    title = it.title.toString(),
                    posterPath = "https://image.tmdb.org/t/p/original/" + it.poster_path.toString(),
                    mediaType = MediaType.getMediaType(it.media_type.toString())
                )
            }.orEmpty()
        }
    }
}