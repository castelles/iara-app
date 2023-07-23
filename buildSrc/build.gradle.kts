import Build_gradle.InternalDep.buildGradle
import Build_gradle.InternalDep.kotlinGradle
import Build_gradle.InternalDep.navigationPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object InternalDep {
    private const val kotlinVersion = "1.7.0"
    private const val buildGradleVersion = "7.4.1"
    private const val navigationVersion = "2.3.3"

    const val buildGradle = "com.android.tools.build:gradle:$buildGradleVersion"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"

    const val quadrant_gradle_plugin = "gradle.plugin.com.gaelmarhic:quadrant:1.5"
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
    google()
    mavenCentral()
    maven(url = "https://plugins.gradle.org/m2/")
}

dependencies {
    compileOnly(gradleApi())

    implementation(buildGradle)
    implementation(kotlinGradle)
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