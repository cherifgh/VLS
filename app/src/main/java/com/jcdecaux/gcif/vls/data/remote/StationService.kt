package com.jcdecaux.gcif.vls.data.remote

import com.jcdecaux.gcif.vls.data.remote.model.Station
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author cherif
 * @since 03/11/17.
 */
@Singleton
class StationService
@Inject
constructor(
        private val stationApi: StationApi
) {

    fun getAll(): Flowable<List<Station>> {
        return stationApi.getAll()
                .subscribeOn(Schedulers.io())
    }

    fun getAll(contract: String): Flowable<List<Station>> {
        return stationApi.getAll(contract)
                .subscribeOn(Schedulers.io())
    }

    fun get(contract: String, number: Int): Flowable<Station> {
        return stationApi.get(contract, number)
                .subscribeOn(Schedulers.io())
    }
}