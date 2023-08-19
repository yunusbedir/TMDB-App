package ui.screen.top.search

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ui.base.BaseScreenModel

class SearchScreenViewModel : BaseScreenModel() {

    init {
        println("MY_LOG , SearchScreenViewModel.init")
    }

    override fun onDispose() {
        println("MY_LOG , SearchScreenViewModel.onDispose()")
        super.onDispose()
    }

    private val _uiState = MutableStateFlow(SearchScreenState())
    val uiState
        get() = _uiState.asStateFlow()

    fun search(searchText: String) {
        viewModelScope.launch {
            delay(1000)
            _uiState.update {
                it.copy(
                    moviesAndTvSeries = listOf(
                        "moviesAndTvSeries1",
                        "moviesAndTvSeries2",
                        "moviesAndTvSeries3",
                        "moviesAndTvSeries2",
                        "moviesAndTvSeries3",
                        "moviesAndTvSeries2",
                        "moviesAndTvSeries3"
                    )
                )
            }
        }
    }
}

data class SearchScreenState(
    var moviesAndTvSeries: List<String> = listOf()
)