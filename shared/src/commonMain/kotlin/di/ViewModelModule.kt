package di

import org.koin.dsl.module
import ui.presentation.tab.home.HomeScreenViewModel


fun getScreenModelModule() = module {
    factory { HomeScreenViewModel(get(), get()) }
}