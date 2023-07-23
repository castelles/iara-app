package castelles.com.github.gradleconfiguration.libs

object Kotlin: DependencyContainer {

    private const val buildGradleVersion = "4.2.1"
    private const val kotlinVersion = "1.5.21"

    const val buildGradle = "com.android.tools.build:gradle:$buildGradleVersion"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    private const val kotlinstdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

    override val list: List<String>
        get() = listOf(kotlinstdlib)

}