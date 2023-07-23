package castelles.com.github.api.di

import okhttp3.logging.HttpLoggingInterceptor

interface LoggingInterceptor {
    fun getInterceptor(): HttpLoggingInterceptor
}