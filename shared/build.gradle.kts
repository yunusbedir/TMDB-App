plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] =
            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                with(Deps.Koin) {
                    implementation(core)
                    implementation(composeMp)
                }
                with(Deps.Ktor) {
                    implementation(clientJson)
                    implementation(clientLogging)
                    implementation(serialization)
                    implementation(clientContentNegotiation)
                    implementation(serializationKotlinxJson)
                }
                with(Deps.Kotlin) {
                    implementation(serialization)
                }
                with(Deps.Material) {
                    implementation(materialIconExtended)
                }
                with(Deps.Voyager) {
                    implementation(navigator)
                    implementation(transitions)
                    implementation(bottomSheetNavigator)
                    implementation(tabNavigator)
                }

                implementation(Deps.Kamel.kamel)
                implementation(Deps.Compose.util)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Deps.AndroidX.appcompat)
                api(Deps.AndroidX.coreKtx)
                implementation(Deps.Ktor.clientAndroid)
                implementation(Deps.Koin.compose)
                api(Deps.AndroidX.activityCompose)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Deps.Ktor.clientIOS)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.yunusbedir.tmdbapp"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res","src/commonMain/resources")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
