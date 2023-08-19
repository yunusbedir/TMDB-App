package ui.screen.top.home

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ui.base.BaseScreenModel

class HomeScreenViewModel : BaseScreenModel() {

    init {
        println("MY_LOG , HomeScreenViewModel.init")
    }

    override fun onDispose() {
        println("MY_LOG , HomeScreenViewModel.onDispose()")
        super.onDispose()
    }

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState
        get() = _uiState.asStateFlow()

    fun getMovies() {
        viewModelScope.launch {
            delay(1000)
            _uiState.update {
                it.copy(
                    popularMovies = listOf(
                        "popularMovies1",
                        "popularMovies2",
                        "popularMovies5"
                    ),
                    popularTvSeries = listOf(
                        "popularTvSeries1",
                        "popularTvSeries2",
                        "popularTvSeries5"
                    ),
                    bestOfTenMovies = listOf(
                        "bestOfTenMovies1",
                        "bestOfTenMovies2",
                        "bestOfTenMovies5"
                    ),
                    bestOfTenTvSeries = listOf(
                        "bestOfTenTvSeries1",
                        "bestOfTenTvSeries2",
                        "bestOfTenTvSeries5"
                    )
                )
            }
        }
    }
}

data class HomeScreenState(
    var popularMovies: List<String> = listOf(),
    var popularTvSeries: List<String> = listOf(),
    var bestOfTenMovies: List<String> = listOf(),
    var bestOfTenTvSeries: List<String> = listOf()
)