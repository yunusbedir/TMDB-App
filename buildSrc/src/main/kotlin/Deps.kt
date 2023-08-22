object Deps {
    object Kotlin {
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val kotlinxSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinSerialization}"
        const val kotlinWrappersBom =
            "org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:${Versions.kotlinWrappersBom}"
        const val kotlinStyled = "org.jetbrains.kotlin-wrappers:kotlin-styled"

    }

    object Material {
        const val materialIconExtended =
            "org.jetbrains.compose.material:material-icons-extended:${Versions.materialIconVersion}"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientContentNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
        const val serializationKotlinxJson =
            "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

        const val serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"

        // Engines
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"
        const val clientIOS = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientJava = "io.ktor:ktor-client-java:${Versions.ktor}"
        const val clientJs = "io.ktor:ktor-client-js:${Versions.ktor}"

    }


    object Logback {
        const val logbackClassic = "ch.qos.logback:logback-classic:${Versions.logbackClassic}"
    }

    object SQLDelight {
        const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        const val androidDriver = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
        const val sqliteDriver = "app.cash.sqldelight:sqlite-driver:${Versions.sqlDelight}"
        const val nativeDriver = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
        const val sqljsDriver = "app.cash.sqldelight:sqljs-driver:${Versions.sqlDelight}"

        const val coroutinesExtensions =
            "app.cash.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
        const val primitiveAdapters =
            "app.cash.sqldelight:primitive-adapters:${Versions.sqlDelight}"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val test = "io.insert-koin:koin-test:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koinComposeVersion}"
        const val composeMp = "io.insert-koin:koin-compose:${Versions.koinComposeJb}"
    }

    object Voyager {
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
        const val bottomSheetNavigator =
            "cafe.adriel.voyager:voyager-bottom-sheet-navigator:${Versions.voyager}"
        const val tabNavigator = "cafe.adriel.voyager:voyager-tab-navigator:${Versions.voyager}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyager}"
        const val koin = "cafe.adriel.voyager:voyager-koin:${Versions.voyager}"

    }

    object Github {
        const val imageLoader = "io.github.qdsfdhvh:image-loader:${Versions.imageLoader}"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    }

    object Compose {
        const val util = "org.jetbrains.compose.ui:ui-util:${Versions.compose}"
    }

    object Gradle {

       const val android ="com.android.tools.build:gradle${Versions.gradlePlugin}"
       const val compose ="org.jetbrains.compose:compose-gradle-plugin${Versions.compose}"
       const val kotlin ="org.jetbrains.kotlin:kotlin-gradle-plugin${Versions.kotlin}"

    }

    object Kamel {
        const val kamel = "media.kamel:kamel-image:${Versions.kamel}"
    }

}
/*
[libraries]

multiplatform-placeholder = { module = "ca.gosyer:accompanist-placeholder", version.ref = "multiplatform-placeholder" }

junit = "junit:junit:4.13.2"
 */