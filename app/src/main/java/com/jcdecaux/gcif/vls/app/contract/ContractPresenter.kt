package com.jcdecaux.gcif.vls.app.contract

import com.jcdecaux.gcif.vls.data.ContractRepository
import com.jcdecaux.gcif.vls.extension.disposeOn
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable

/**
 * @author cherif
 * @since 04/11/17.
 */
class ContractPresenter(
        private val repository: ContractRepository,
        private val view: ContractContract.View,
        private val scheduler: Scheduler
) : ContractContract.Presenter {

    private val mCompositeDisposable = CompositeDisposable()

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        loadContracts()
    }

    override fun loadContracts() {
        mCompositeDisposable.clear()

        repository.getAll()
                .observeOn(scheduler)
                .doOnSubscribe { view.setLoading(true) }
                .doOnTerminate { view.setLoading(false) }
                .subscribe({ contracts ->
                    view.showContracts(contracts)
                }, { e ->
                    view.showLoadContractsError(e)
                }).disposeOn(mCompositeDisposable)
    }

    override fun unsubscribe() {
        mCompositeDisposable.clear()
    }
}