package castelles.com.github.gradleconfiguration.libs

object Test: DependencyContainer {

    private const val junitVersion = "4.+"
    private const val junit = "junit:junit:$junitVersion"

    override val list: List<String>
        get() = listOf(
            junit
        )

    object AndroidTest: DependencyContainer {
        private const val junitAndroidXVersion = "1.1.3"
        private const val espressoVersion = "3.4.0"

        private const val junitAndroidX = "androidx.test.ext:junit:$junitAndroidXVersion"
        private const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"

        override val list: List<String>
            get() = listOf(
                junitAndroidX,
                espresso
            )
    }
}