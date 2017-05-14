package com.golfpinhunter.seoul

import com.golfpinhunter.seoul.di.ApplicationScope
import dagger.Component

/**
 * Created by nicholaspark on 5/10/17.
 */
@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class))
interface SeoulComponent : AppComponent {

    class Initializer private constructor() {

        companion object {
            @JvmStatic fun init(seoulApplication: SeoulApplication) : SeoulComponent {
                return DaggerSeoulComponent
                        .builder()
                        .applicationModule(ApplicationModule(seoulApplication))
                        .build()
            }
        }
    }
}