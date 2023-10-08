package castelles.com.github.gradleconfiguration.libs

object Utils: DependencyContainer {

    private const val dimesLayoutVersion = "1.0.5"
    private const val dimensSdp = "com.intuit.sdp:sdp-android:$dimesLayoutVersion"

    private const val lottieVersion = "4.2.0"
    private const val lottie = "com.airbnb.android:lottie:$lottieVersion"

    private const val glideVersion = "4.16.0"
    private const val glide = "com.github.bumptech.glide:glide:$glideVersion"


    override val list: List<String>
        get() = listOf(
            dimensSdp,
            lottie,
            glide
        )
}