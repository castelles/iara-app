package castelles.com.github.gradleconfiguration.libs

object Jetpack: DependencyContainer {

    private const val navigationVersion = "2.3.3"
    private const val navigationKtxVersion = "2.3.5"
    private const val fragmentVersion = "1.3.+"
    private const val viewModelSavedStateVersion = "2.3.0"
    private const val flowJvmVersion = "1.4.1"

    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationKtxVersion"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationKtxVersion"
    private const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
    private const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$viewModelSavedStateVersion"
    private const val coroutinesFlow = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$flowJvmVersion"

    override val list: List<String>
        get() = listOf(
            navigationFragment,
            navigationUi,
            viewModelSavedState,
            fragment
        )
}