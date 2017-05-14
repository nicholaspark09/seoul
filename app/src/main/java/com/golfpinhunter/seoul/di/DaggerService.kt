package com.golfpinhunter.seoul.di

import android.content.Context
import com.golfpinhunter.seoul.AppComponent

/**
 * Created by nicholaspark on 5/10/17.
 */
class DaggerService private constructor () {
    companion object {
        @JvmStatic val SERVICE_NAME = DaggerService.javaClass.name
        @JvmStatic fun getAppComponent(context: Context): AppComponent {
            return context.applicationContext.getSystemService(SERVICE_NAME) as AppComponent
        }
    }

}