package com.golfpinhunter.seoul.ui.main

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import com.golfpinhunter.seoul.R
import com.golfpinhunter.seoul.di.DaggerService
import com.golfpinhunter.seoul.utils.ActivityUtils

class MainActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dagger injection
        DaggerService.getAppComponent(this).inject(this)

        var mainFragment: MainFragment? = supportFragmentManager.findFragmentById(R.id.contentFrame) as? MainFragment
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            ActivityUtils.addFragmentToActivity(
                    supportFragmentManager,
                    mainFragment,
                    R.id.contentFrame
            )
        }

    }
}
