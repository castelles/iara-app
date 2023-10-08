import castelles.com.github.gradleconfiguration.extensions.androidTestImplementationAll
import castelles.com.github.gradleconfiguration.extensions.implementationAll
import castelles.com.github.gradleconfiguration.libs.Compose
import castelles.com.github.gradleconfiguration.libs.Jetpack
import castelles.com.github.gradleconfiguration.libs.Firebase
import castelles.com.github.gradleconfiguration.libs.Test
import castelles.com.github.gradleconfiguration.libs.Utils
import castelles.com.github.gradleconfiguration.libs.GoogleMaps

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-standard-settings")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":api"))
    implementation(project(":designsystem"))
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementationAll(Jetpack.list)
    implementationAll(Utils.list)
    implementationAll(GoogleMaps.list)
    androidTestImplementationAll(Compose.AndroidTest.list)
    androidTestImplementationAll(Test.AndroidTest.list)
    kapt ("com.github.bumptech.glide:compiler:4.16.0")

    implementation(platform(Firebase.bom))
    implementationAll(Firebase.list)

}