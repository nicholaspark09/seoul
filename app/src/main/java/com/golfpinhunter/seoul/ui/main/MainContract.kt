package com.golfpinhunter.seoul.ui.main

import com.golfpinhunter.seoul.ui.base.BasePresenter
import com.golfpinhunter.seoul.ui.base.BaseView

/**
 * Created by nicholaspark on 5/12/17.
 */
interface MainContract {

    interface View : BaseView<Presenter> {
        fun showArticles()
        fun showSlider()
    }

    interface Presenter : BasePresenter {
        fun loadArticles()
        fun loadSlider()
        //fun setMainView(view: View)
    }
}