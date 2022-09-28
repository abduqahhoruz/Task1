package uz.harmonic.task1

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object{
        lateinit var appContext: Context
    }
}