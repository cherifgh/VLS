package com.jcdecaux.gcif.vls.data.remote

import com.jcdecaux.gcif.vls.data.ContractRepository
import com.jcdecaux.gcif.vls.data.local.model.Contract
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author cherif
 * @since 03/11/17.
 */
@Singleton
class ContractService
@Inject
constructor(
        private val contractApi: ContractApi
) : ContractRepository {

    override fun getAll(): Flowable<List<Contract>> {
        return contractApi.getAll()
                .subscribeOn(Schedulers.io())
                .map(Contract.Companion::from)
    }
}