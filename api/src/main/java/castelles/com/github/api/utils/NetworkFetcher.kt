package castelles.com.github.api.utils

sealed interface NetworkFetcher<out T> {
    data class Success<T>(val result: T?) : NetworkFetcher<T>
    data class Error(val error: ErrorHandler): NetworkFetcher<Nothing>
    object Loading: NetworkFetcher<Nothing>
}
