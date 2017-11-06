package com.jcdecaux.gcif.vls.app.main

import com.jcdecaux.gcif.vls.BasePresenter
import com.jcdecaux.gcif.vls.BaseView

/**
 * @author cherif
 * @since 04/11/17.
 */
interface MainContract {

    interface Presenter : BasePresenter {
        fun openContractsScreen()
    }

    interface View : BaseView<Presenter> {
        var isActive: Boolean

        fun showContractsActivity()
    }
}