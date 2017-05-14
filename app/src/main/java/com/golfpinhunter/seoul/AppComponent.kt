package com.golfpinhunter.seoul

import com.golfpinhunter.seoul.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by nicholaspark on 5/9/17.
 */
@Singleton @Component(modules = arrayOf(ApplicationModule::class))
interface AppComponent {

    fun inject(seoulApplication: SeoulApplication)

    fun inject(mainActivity: MainActivity)
}