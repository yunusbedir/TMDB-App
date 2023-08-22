package di

import data.remote.TMDBService
import data.repository.TMDBServiceRepositoryImpl
import domain.repository.TMDBServiceRepository
import domain.usecase.GetTrendingAllOfDayUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpCallValidator
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import platformModule
import ui.presentation.tab.home.HomeScreenViewModel


fun initKoin(
    appDeclaration: KoinAppDeclaration = {},
) = startKoin {
    appDeclaration()
    modules(commonModule())
}


fun initKoin() = initKoin() {}


fun commonModule() =
    platformModule() +
            getDataModule(baseUrl = "https://api.themoviedb.org/3") +
            getUseCaseModule() +
            getScreenModelModule()


fun getScreenModelModule() = module {
    factory { HomeScreenViewModel(get()) }
}

fun getDataModule(
    baseUrl: String,
    enableNetworkLogs: Boolean = true,
) = module {
    single<TMDBServiceRepository> { TMDBServiceRepositoryImpl(get()) }

    single { TMDBService(get(), baseUrl = baseUrl) }

    single { createJson() }

    single { createHttpClient(get(), get(), enableNetworkLogs = enableNetworkLogs) }
}

fun getUseCaseModule() = module {
    single { GetTrendingAllOfDayUseCase(get()) }

}

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json, enableNetworkLogs: Boolean) =
    HttpClient(httpClientEngine) {
        defaultRequest { header("api_key", "2fd7b5cc824fc9ba532f207ad3da4908") }

        // exception handling
        install(HttpTimeout) {
            requestTimeoutMillis = 10000
            connectTimeoutMillis = 10000
            socketTimeoutMillis = 10000
        }

        install(HttpRequestRetry) {
            maxRetries = 3
            retryIf { _, response -> !response.status.isSuccess() }
            retryOnExceptionIf { _, cause -> cause is HttpRequestTimeoutException }
            delayMillis { 3000L } // retries in 3, 6, 9, etc. seconds
        }

        install(HttpCallValidator) {
            handleResponseExceptionWithRequest { cause, _ -> println("exception $cause") }
        }

        install(ContentNegotiation) { json(json) }
        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

@OptIn(ExperimentalSerializationApi::class)
fun createJson() = Json {
    ignoreUnknownKeys = true
    isLenient = true
    encodeDefaults = true
    prettyPrint = true
    explicitNulls = false
    coerceInputValues = true
}