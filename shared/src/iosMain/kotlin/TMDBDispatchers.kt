import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val tMDBDispatchers: TMDBDispatchers = object : TMDBDispatchers {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.Default

    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}