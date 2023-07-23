package castelles.com.github.gradleconfiguration.libs

interface DependencyContainer {

    val list: List<String>
    val kapt: String
        get() = ""
}