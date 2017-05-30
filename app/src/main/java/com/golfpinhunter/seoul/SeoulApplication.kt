package com.golfpinhunter.seoul

import android.app.Application
import com.golfpinhunter.seoul.di.DaggerService
import com.squareup.leakcanary.LeakCanary

/**
 * Created by nicholaspark on 5/9/17.
 */
open class SeoulApplication : Application() {

    /**
     *  Build the component
     */
    val component: AppComponent by lazy {
        SeoulComponent.Initializer.init(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
        component.inject(this)
    }

    override fun getSystemService(name: String?): Any {
        if (name.equals(DaggerService.SERVICE_NAME) && component != null) {
            return component
        }
        return super.getSystemService(name)
    }
}