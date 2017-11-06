package com.jcdecaux.gcif.vls.data.remote

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
interface StationApi {
    @GET("stations")
    fun getAll(): Flowable<List<Station>>

    @GET("stations")
    fun getAll(@Query("contract") contract: String): Flowable<List<Station>>

    @GET("stations/{station_number}")
    fun get(@Query("contract") contract: String,
            @Path("station_number") number: Int): Flowable<Station>
}