package ui.screen.top.favorite

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ui.base.BaseScreenModel

class FavoriteScreenViewModel : BaseScreenModel() {

    init {
        println("MY_LOG , FavoriteScreenViewModel.init")
    }

    override fun onDispose() {
        println("MY_LOG , FavoriteScreenViewModel.onDispose()")
        super.onDispose()
    }

    private val _uiState = MutableStateFlow(FavoriteScreenState())
    val uiState
        get() = _uiState.asStateFlow()

    fun getFavorites() {
        viewModelScope.launch {
            delay(1000)
            _uiState.update {
                it.copy(
                    movies = listOf(
                        "movies1",
                        "movies2",
                        "movies3",
                        "movies2",
                        "movies3",
                        "movies2",
                        "movies3"
                    ),
                    tvSeries = listOf(
                        "TvSeries1",
                        "TvSeries2",
                        "TvSeries3",
                        "TvSeries2",
                        "TvSeries3",
                        "TvSeries2",
                        "TvSeries3"
                    )
                )
            }
        }
    }
}

data class FavoriteScreenState(
    var movies: List<String> = listOf(),
    var tvSeries: List<String> = listOf()
)