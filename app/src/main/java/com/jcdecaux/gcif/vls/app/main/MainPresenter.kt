package com.jcdecaux.gcif.vls.app.main

/**
 * @author cherif
 * @since 04/11/17.
 */
class MainPresenter(
        private val view: MainContract.View
) : MainContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun openContractsScreen() {
        view.showContractsActivity()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }
}