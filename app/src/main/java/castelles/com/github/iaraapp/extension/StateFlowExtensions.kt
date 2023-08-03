package castelles.com.github.iaraapp.extension

import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Allows StateFlow to emit the same value sequentially.
 * On collect implementation, ignore the null value if it´s not mapped.
 */
suspend inline fun <reified T> MutableStateFlow<T?>.safeEmit(field: T?) {
    emit(field)
    emit(null)
}