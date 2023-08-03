package castelles.com.github.iaraapp.app

import android.app.Application
import castelles.com.github.iaraapp.module.dataSourceModules
import castelles.com.github.iaraapp.module.repositoryModules
import castelles.com.github.iaraapp.module.viewModelModules
import castelles.com.github.api.di.networkModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(
                networkModules,
                dataSourceModules,
                repositoryModules,
                viewModelModules
            )
        }
    }
}