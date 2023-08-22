package ui.presentation.tab.home

import domain.UseCaseState
import domain.model.result.BaseMediaModel
import domain.model.result.MediaResult
import domain.model.result.MediaType
import domain.usecase.GetMoviesUseCase
import domain.usecase.GetTvSeriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ui.base.BaseScreenModel

class HomeScreenViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getTvSeriesUseCase: GetTvSeriesUseCase,
) : BaseScreenModel() {

    private val _uiStateMovie = MutableStateFlow(MovieScreenState())
    val uiStateMovie
        get() = _uiStateMovie.asStateFlow()

    private val _uiStateTv = MutableStateFlow(TvScreenState())
    val uiStateTv
        get() = _uiStateTv.asStateFlow()

    fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase.invoke().collectLatest { useCaseState ->
                when (useCaseState) {
                    is UseCaseState.Error -> {

                    }

                    is UseCaseState.Success -> {
                        _uiStateMovie.update {
                            it.copy(
                                popular = useCaseState.result.popular,
                                trendsOfDay = useCaseState.result.trendsOfDay,
                                topRated = useCaseState.result.topRated,
                                nowPlaying = useCaseState.result.nowPlaying,
                                upComing = useCaseState.result.upComing,
                            )
                        }
                    }
                }
            }
        }
    }

    fun getTv() {
        viewModelScope.launch {
            getTvSeriesUseCase.invoke().collectLatest { useCaseState ->
                when (useCaseState) {
                    is UseCaseState.Error -> {

                    }

                    is UseCaseState.Success -> {
                        _uiStateTv.update {
                            it.copy(
                                popular = useCaseState.result.popular,
                                trendsOfDay = useCaseState.result.trendsOfDay,
                                topRated = useCaseState.result.topRated,
                                onTheAir = useCaseState.result.onTheAir,
                                airingToday = useCaseState.result.airingToday,
                            )
                        }
                    }
                }
            }
        }
    }
}

val tempList = listOf(
    MediaResult(
        id = "832502",
        title = "The Monkey King",
        posterPath = "https://image.tmdb.org/t/p/original/2D6ksPSChcRcZuvavrae9g4b8oh.jpg",
        backdropPath = "https://image.tmdb.org/t/p/original/2D6ksPSChcRcZuvavrae9g4b8oh.jpg",
        mediaType = MediaType.MOVIE,
    ),
    MediaResult(
        id = "976573",
        title = "Elemental",
        posterPath = "https://image.tmdb.org/t/p/original/6oH378KUfCEitzJkm07r97L0RsZ.jpg",
        backdropPath = "https://image.tmdb.org/t/p/original/6oH378KUfCEitzJkm07r97L0RsZ.jpg",
        mediaType = MediaType.MOVIE,
    ),
    MediaResult(
        id = "565770",
        title = "Blue Beetle",
        posterPath = "https://image.tmdb.org/t/p/original/lZ2sOCMCcGaPppaXj0Wiv0S7A08.jpg",
        backdropPath = "https://image.tmdb.org/t/p/original/lZ2sOCMCcGaPppaXj0Wiv0S7A08.jpg",
        mediaType = MediaType.MOVIE,
    ),
    MediaResult(
        id = "569094",
        title = "Spider-Man: Across the Spider-Verse",
        posterPath = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
        backdropPath = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
        mediaType = MediaType.MOVIE,
    )
)

data class MovieScreenState(
    var trendsOfDay: List<BaseMediaModel> = listOf(),
    var popular: List<BaseMediaModel> = listOf(),
    var topRated: List<BaseMediaModel> = listOf(),
    var nowPlaying: List<BaseMediaModel> = listOf(),
    var upComing: List<BaseMediaModel> = listOf(),
)

data class TvScreenState(
    var trendsOfDay: List<BaseMediaModel> = listOf(),
    var popular: List<BaseMediaModel> = listOf(),
    var topRated: List<BaseMediaModel> = listOf(),
    var onTheAir: List<BaseMediaModel> = listOf(),
    var airingToday: List<BaseMediaModel> = listOf(),
)