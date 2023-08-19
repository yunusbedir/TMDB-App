import kotlinx.coroutines.CoroutineDispatcher

interface TMDBDispatchers {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

expect val tMDBDispatchers: TMDBDispatchers