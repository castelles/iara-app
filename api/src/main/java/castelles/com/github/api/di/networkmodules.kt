package castelles.com.github.api.di

import castelles.com.github.api.di.ModuleConstants.LATENCY_LIMIT_TIME
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val networkModules = module {

    single<LoggingInterceptor> { LoggingInterceptorImpl() }

    single<OkHttpClient.Builder> {
        val client = OkHttpClient().newBuilder()
            .connectTimeout(LATENCY_LIMIT_TIME, TimeUnit.SECONDS)
            .readTimeout(LATENCY_LIMIT_TIME, TimeUnit.SECONDS)
            .writeTimeout(LATENCY_LIMIT_TIME, TimeUnit.SECONDS)

        with(client) {
            addInterceptor(get<LoggingInterceptor>().getInterceptor())
        }
    }
}

object ModuleConstants {
    const val LATENCY_LIMIT_TIME = 15L
}