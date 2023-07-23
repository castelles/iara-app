package castelles.com.github.gradleconfiguration.libs

object Jetpack: DependencyContainer {

    private val navigationVersion = "2.3.3"
    private val navigationKtxVersion = "2.3.5"
    private val fragmentVersion = "1.3.+"
    private val viewModelSavedStateVersion = "2.3.0"
    private val flowJvmVersion = "1.4.1"

    private val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
    private val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationKtxVersion"
    private val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationKtxVersion"
    private val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
    private val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$viewModelSavedStateVersion"
    private val coroutinesFlow = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$flowJvmVersion"

    override val list: List<String>
        get() = listOf(
            navigationFragment,
            navigationUi,
            viewModelSavedState,
            fragment
        )
}