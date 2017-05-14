package com.golfpinhunter.seoul.ui.main

import android.support.annotation.VisibleForTesting
import com.golfpinhunter.seoul.di.ApplicationScope
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by nicholaspark on 5/12/17.
 */
@ApplicationScope
class MainPresenter @Inject constructor() : MainContract.Presenter  {

    var view : MainContract.View
        get() = view
        set(mView: MainContract.View) {
            view = mView
        }

    lateinit var disposables: CompositeDisposable


    override fun start() {
        disposables = CompositeDisposable()
        loadArticles()
    }

    override fun unsubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (disposables != null) {
            disposables.clear()
        }

    }

    override fun loadArticles() {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadSlider() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}