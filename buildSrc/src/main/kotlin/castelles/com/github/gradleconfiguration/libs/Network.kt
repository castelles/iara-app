package castelles.com.github.gradleconfiguration.libs

object Network: DependencyContainer {

    private const val gsonVersion = "2.8.6"
    private const val loggingVersion = "4.7.2"
    private const val okhttpVersion = "2.7.2"
    private const val retrofitVersion = "2.9.0"

    private const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    private const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    private const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    //    const val scalarsConverter = "com.squareup.retrofit2:converter-scalars:${Versions}"
    private const val gson = "com.google.code.gson:gson:$gsonVersion"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$loggingVersion"
    private const val okHttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"

    override val list: List<String>
        get() = listOf(
            retrofit,
            gsonConverter,
            moshiConverter,
            gson,
            loggingInterceptor,
            okHttp,
        )

}