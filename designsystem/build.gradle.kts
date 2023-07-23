import castelles.com.github.gradleconfiguration.extensions.implementationAll
import castelles.com.github.gradleconfiguration.libs.Compose

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-standard-settings")
}

android {
    namespace = "castelles.com.github.androidbaseproject.designsystem"
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementationAll(Compose.list)
}