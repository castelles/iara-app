package castelles.com.github.gradleconfiguration.libs

object Koin: DependencyContainer {

    private const val koinVersion = "2.2.0"
    private const val koin = "org.koin:koin-android:$koinVersion"
    private const val koinScope = "org.koin:koin-android-scope:$koinVersion"
    private const val koinViewModel= "org.koin:koin-android-viewmodel:$koinVersion"

    override val list: List<String>
        get() = listOf(
            koin,
            koinScope,
            koinViewModel
        )
}