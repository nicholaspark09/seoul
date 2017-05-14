package com.golfpinhunter.seoul.utils


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by nicholaspark on 5/12/17.
 */
object ActivityUtils {

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment,
                              frameId: Int) {
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }
}