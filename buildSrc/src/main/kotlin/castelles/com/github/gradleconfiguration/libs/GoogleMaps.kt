package castelles.com.github.gradleconfiguration.libs

object GoogleMaps: DependencyContainer {

    private const val mapsVersion = "18.1.0"
    private const val maps = "com.google.android.gms:play-services-maps:$mapsVersion"

    override val list: List<String>
        get() = listOf(
            maps
        )
}