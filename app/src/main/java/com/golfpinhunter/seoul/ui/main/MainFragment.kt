package com.golfpinhunter.seoul.ui.main

import android.support.v4.app.Fragment
import javax.inject.Inject

/**
 * Created by nicholaspark on 5/12/17.
 */
class MainFragment : Fragment(), MainContract.View {

    @Inject lateinit var presenter : MainPresenter

    override fun onResume() {
        super.onResume()
        presenter.view = this
        presenter.start()
    }

    override fun showError(error: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLoadingIndicator(isLoading: Boolean) {
        if (view == null) {
            return
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showArticles() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSlider() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

}