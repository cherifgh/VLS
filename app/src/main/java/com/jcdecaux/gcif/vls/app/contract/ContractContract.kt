package com.jcdecaux.gcif.vls.app.contract

import com.jcdecaux.gcif.vls.BasePresenter
import com.jcdecaux.gcif.vls.BaseView
import com.jcdecaux.gcif.vls.data.local.model.Contract

/**
 * @author cherif
 * @since 04/11/17.
 */
interface ContractContract {

    interface Presenter : BasePresenter {
        fun loadContracts()
    }

    interface View : BaseView<Presenter> {
        var isActive: Boolean

        fun showContracts(contracts: List<Contract>)

        fun showLoadContractsError(exception: Throwable)

        fun setLoading(isLoading: Boolean)
    }
}