package castelles.com.github.api.di

import castelles.com.github.api.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorImpl: LoggingInterceptor {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
    }

    override fun getInterceptor() = interceptor
}