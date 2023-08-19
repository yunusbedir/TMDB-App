import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val tMDBDispatchers: TMDBDispatchers = object : TMDBDispatchers {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main.immediate

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}