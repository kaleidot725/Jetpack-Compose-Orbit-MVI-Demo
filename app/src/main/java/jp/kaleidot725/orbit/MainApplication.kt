package jp.kaleidot725.orbit

import android.app.Application
import jp.kaleidot725.orbit.data.dataModule
import jp.kaleidot725.orbit.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MainApplication)
            modules(appModule, domainModule, dataModule)
        }
    }
}