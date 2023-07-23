package castelles.com.github.gradleconfiguration.plugins

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import castelles.com.github.gradleconfiguration.extensions.*
import castelles.com.github.gradleconfiguration.libs.*

class LibsPlugin: BasicConfigurationPlugin() {

    override fun apply(target: Project) {
        super.apply(target)
        applyStandardDependencies(target)
    }

    private fun applyStandardDependencies(project: Project) {
        project.dependencies {
            implementationAll(Android.list)
            implementationAll(Rx.list)
            testImplementationAll(Test.list)
            androidTestImplementationAll(Test.AndroidTest.list)
            debugImplementationAll(Test.Debug.list)
        }
    }

}