package com.golfpinhunter.seoul.ui.base

/**
 * Created by nicholaspark on 5/9/17.
 */

interface BaseView<T> {
    fun showError(error: String)
    fun setLoadingIndicator(isLoading: Boolean)
    fun setPresenter(presenter: T)
}