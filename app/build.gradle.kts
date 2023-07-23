import castelles.com.github.gradleconfiguration.extensions.androidTestImplementationAll
import castelles.com.github.gradleconfiguration.extensions.implementationAll
import castelles.com.github.gradleconfiguration.libs.Compose
import castelles.com.github.gradleconfiguration.libs.Jetpack
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

    implementation(project(":api"))
    implementation(project(":designsystem"))
    implementationAll(Jetpack.list)
    implementationAll(Utils.list)
    androidTestImplementationAll(Compose.AndroidTest.list)
    androidTestImplementationAll(castelles.com.github.gradleconfiguration.libs.Test.AndroidTest.list)
}