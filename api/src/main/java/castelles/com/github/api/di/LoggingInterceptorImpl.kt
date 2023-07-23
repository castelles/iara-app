package castelles.com.github.api.di

import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorImpl: LoggingInterceptor {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    override fun getInterceptor() = interceptor
}