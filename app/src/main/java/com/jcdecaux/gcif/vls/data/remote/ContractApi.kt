package com.jcdecaux.gcif.vls.data.remote

import com.jcdecaux.gcif.vls.data.remote.model.Contract
import com.jcdecaux.gcif.vls.data.remote.model.Station
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author cherif
 * @since 03/11/17.
 */
interface ContractApi {
    @GET("contracts")
    fun getAll(): Flowable<List<Contract>>
}