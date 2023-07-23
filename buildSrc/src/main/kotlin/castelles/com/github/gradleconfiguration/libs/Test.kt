package castelles.com.github.gradleconfiguration.libs

object Test: DependencyContainer {

    private const val junitVersion = "4.+"
    private const val junit = "junit:junit:$junitVersion"
    private const val composeTestVersion = "1.0.1"

    override val list: List<String>
        get() = listOf(
            junit
        )

    object AndroidTest: DependencyContainer {
        private const val junitAndroidXVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        private const val junitAndroidX = "androidx.test.ext:junit:$junitAndroidXVersion"
        private const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
        private const val composeTest = "androidx.compose.ui:ui-test-junit4:$composeTestVersion"

        override val list: List<String>
            get() = listOf(
                junitAndroidX,
                espresso,
                composeTest
            )
    }

    object Debug: DependencyContainer {

        private const val debugCompose = "androidx.compose.ui:ui-tooling:$composeTestVersion"

        override val list: List<String>
            get() = listOf(
                debugCompose
            )
    }
}