import castelles.com.github.gradleconfiguration.extensions.implementationAll
import castelles.com.github.gradleconfiguration.libs.Jetpack
import castelles.com.github.gradleconfiguration.libs.Koin
import castelles.com.github.gradleconfiguration.libs.Utils

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-standard-settings")
}

android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation (project(":api"))
    implementationAll(Jetpack.list)
    implementationAll(Koin.list)
    implementationAll(Utils.list)

}