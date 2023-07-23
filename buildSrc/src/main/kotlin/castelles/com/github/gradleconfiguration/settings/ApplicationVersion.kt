package castelles.com.github.gradleconfiguration.settings

object ApplicationVersion {
    private const val release ="1"
    private const val feature = "0"
    private const val fix = "0"
    private const val hotFix = "0"
    const val versionName = "$release.$feature.$fix.$hotFix"
    const val appName = "Base"
}