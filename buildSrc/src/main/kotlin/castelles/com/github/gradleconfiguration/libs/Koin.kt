package castelles.com.github.gradleconfiguration.libs

object Koin: DependencyContainer {

    private const val koinVersion = "3.2.2"

    private const val scope = "io.insert-koin:koin-android:$koinVersion"
    private const val workManager = "io.insert-koin:koin-androidx-workmanager:$koinVersion"
    private const val compose = "io.insert-koin:koin-androidx-compose:$koinVersion"
    private const val compat = "io.insert-koin:koin-android-compat:$koinVersion"

    override val list: List<String>
        get() = listOf(
            scope,
            workManager,
            compose,
            compat
        )
}