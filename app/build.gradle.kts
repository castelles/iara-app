import castelles.com.github.gradleconfiguration.extensions.androidTestImplementationAll
import castelles.com.github.gradleconfiguration.extensions.implementationAll
import castelles.com.github.gradleconfiguration.libs.Compose
import castelles.com.github.gradleconfiguration.libs.Jetpack
import castelles.com.github.gradleconfiguration.libs.Firebase
import castelles.com.github.gradleconfiguration.libs.Test
import castelles.com.github.gradleconfiguration.libs.Utils

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-standard-settings")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
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
    androidTestImplementationAll(Test.AndroidTest.list)

    implementation(platform(Firebase.bom))
    implementationAll(Firebase.list)

}