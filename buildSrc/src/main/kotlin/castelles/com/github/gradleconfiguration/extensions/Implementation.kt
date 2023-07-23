package castelles.com.github.gradleconfiguration.extensions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementationAll(dependencyList: List<Any>): List<Dependency?> =
    dependencyList.map { add("implementation", it) }

fun DependencyHandler.testImplementationAll(dependencyList: List<Any>): List<Dependency?> =
    dependencyList.map { add("testImplementation", it) }

fun DependencyHandler.androidTestImplementationAll(dependencyList: List<Any>): List<Dependency?> =
    dependencyList.map { add("androidTestImplementation", it) }

fun DependencyHandler.debugImplementationAll(dependencyList: List<Any>): List<Dependency?> =
    dependencyList.map { add("debugImplementation", it) }

fun DependencyHandler.flavorImplementationAll(flavor: String, dependencyList: List<Any>): List<Dependency?> =
    dependencyList.map { add("${flavor}Implementation", it) }