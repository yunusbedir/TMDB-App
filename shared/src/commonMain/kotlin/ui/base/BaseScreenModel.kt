package ui.base

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import tMDBDispatchers
import kotlin.coroutines.CoroutineContext

abstract class BaseScreenModel : ScreenModel {

    private val job = SupervisorJob()
    private val coroutineContextX: CoroutineContext = job + tMDBDispatchers.io
    protected val viewModelScope = CoroutineScope(coroutineContextX)


}