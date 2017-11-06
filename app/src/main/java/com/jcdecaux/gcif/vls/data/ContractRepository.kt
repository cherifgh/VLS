package com.jcdecaux.gcif.vls.data

import com.jcdecaux.gcif.vls.data.local.model.Contract
import io.reactivex.Flowable

/**
 * @author cherif
 * @since 04/11/17.
 */
interface ContractRepository {

    fun getAll(): Flowable<List<Contract>>
}