package jp.kaleidot725.orbit

import android.app.Application
import jp.kaleidot725.data.dataModule
import jp.kaleidot725.orbit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule, dataModule)
        }
    }
}