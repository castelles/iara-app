package castelles.com.github.gradleconfiguration.libs

object Firebase : DependencyContainer {

    private const val bom_version = "26.7.0"

    const val bom = "com.google.firebase:firebase-bom:$bom_version"

    private const val fbAnalytics = "com.google.firebase:firebase-analytics"
    private const val fbMessaging = "com.google.firebase:firebase-messaging"
    private const val fbIid = "com.google.firebase:firebase-iid"
    private const val config = "com.google.firebase:firebase-config"
    private const val crashlytics = "com.google.firebase:firebase-crashlytics"
    private const val inApp = "com.google.firebase:firebase-inappmessaging-display"
    private const val dynamicLink = "com.google.firebase:firebase-dynamic-links"
    private const val core = "com.google.firebase:firebase-core"

    override val list: List<String>
        get() = listOf(
            fbAnalytics,
            fbMessaging,
            fbIid,
            config,
            crashlytics,
            inApp,
            dynamicLink,
            core
        )
}