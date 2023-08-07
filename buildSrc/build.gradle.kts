import Build_gradle.InternalDep.buildGradle
import Build_gradle.InternalDep.crashlyticsFirebase
import Build_gradle.InternalDep.googleServices
import Build_gradle.InternalDep.kotlinGradle
import Build_gradle.InternalDep.mapsPlugin
import Build_gradle.InternalDep.navigationPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object InternalDep {
    private const val kotlinVersion = "1.7.0"
    private const val buildGradleVersion = "7.4.1"
    private const val navigationVersion = "2.3.3"

    const val buildGradle = "com.android.tools.build:gradle:$buildGradleVersion"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val googleServices = "com.google.gms:google-services:4.3.15"
    const val crashlyticsFirebase = "com.google.firebase:firebase-crashlytics-gradle:2.9.7"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
    const val quadrant_gradle_plugin = "gradle.plugin.com.gaelmarhic:quadrant:1.5"
    const val mapsPlugin = "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:2.0.1"
}

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.5.21"
}

gradlePlugin {
    plugins {
        register("android-standard-settings") {
            id = "android-standard-settings"
            implementationClass = "castelles.com.github.gradleconfiguration.plugins.LibsPlugin"
        }
    }
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    compileOnly(gradleApi())

    implementation(buildGradle)
    implementation(kotlinGradle)
    implementation(googleServices)
    implementation(Build_gradle.InternalDep.crashlyticsFirebase)
    implementation(navigationPlugin)
    implementation(InternalDep.quadrant_gradle_plugin)
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}