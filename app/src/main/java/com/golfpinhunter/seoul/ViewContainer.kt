package com.golfpinhunter.seoul

import android.app.Activity
import android.view.ViewGroup

/**
 * Created by nicholaspark on 5/12/17.
 */
interface ViewContainer {

    fun defaultContainer(activity: Activity) : ViewContainer {
        return activity.findViewById(android.R.id.content) as ViewContainer
    }

    fun forActivity(activity: Activity) : ViewGroup
}