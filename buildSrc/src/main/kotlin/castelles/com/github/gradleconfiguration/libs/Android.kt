package castelles.com.github.gradleconfiguration.libs

object Android: DependencyContainer {

    private const val coreKtxVersion = "1.5.0"
    private const val appcompatVersion = "1.3.1"
    private const val materialVersion = "1.4.0"
    private const val constraintLayoutVersion = "2.0.4"

    private const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    private const val appCompat = "androidx.appcompat:appcompat:$appcompatVersion"
    private const val materialDesign = "com.google.android.material:material:$materialVersion"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    override val list: List<String>
        get() = listOf(
            coreKtx,
            appCompat,
            materialDesign,
            constraintLayout
        )
}