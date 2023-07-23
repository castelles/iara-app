package castelles.com.github.gradleconfiguration.libs

object Compose: DependencyContainer {

    const val composeBOMVersion = "2022.12.00"
    const val activityComposeVersion = "1.3.1"
    const val uiVersion = "1.2.0"
    const val materialVersion = "1.0.0-alpha11"

    private const val composeBom = "androidx.compose:compose-bom:$composeBOMVersion"
    private const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    private const val ui = "androidx.compose.ui:ui:$uiVersion"
    private const val materialCompose = "androidx.compose.material3:material3:$materialVersion"
    private const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$uiVersion"
    private const val tooling = "androidx.compose.ui:ui-tooling:$uiVersion"
    private const val JUnit = "androidx.compose.ui:ui-test-junit4:$uiVersion"
    private const val manifest = "androidx.compose.ui:ui-test-manifest:$uiVersion"

    override val list: List<String>
        get() = listOf(
//            composeBom,
            activityCompose,
            ui,
            materialCompose,
            toolingPreview
        )

    object Debug: DependencyContainer {
        override val list: List<String>
            get() = listOf(
                tooling,
                manifest
            )
    }

    object AndroidTest: DependencyContainer {
        override val list: List<String>
            get() = listOf(
//                composeBom,
                JUnit
            )
    }
}