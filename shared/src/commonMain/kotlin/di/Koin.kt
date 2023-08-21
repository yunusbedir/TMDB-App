package di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ui.presentation.tab.home.HomeScreenViewModel


fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    modules(commonModule())
}


fun initKoin() = initKoin() {}


fun commonModule() =
    getScreenModelModule()

fun getScreenModelModule() = module {
    factory { HomeScreenViewModel() }
}