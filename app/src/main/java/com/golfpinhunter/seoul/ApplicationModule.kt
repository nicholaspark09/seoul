package com.golfpinhunter.seoul

import android.app.Application
import com.golfpinhunter.seoul.data.DataModule
import com.golfpinhunter.seoul.di.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * Created by nicholaspark on 5/9/17.
 */
@Module (includes = arrayOf(DataModule::class))
class ApplicationModule(val app: Application) {

    @Provides
    @ApplicationScope
    fun provideApplication() = app
}