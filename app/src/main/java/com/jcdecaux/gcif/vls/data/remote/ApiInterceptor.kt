package com.jcdecaux.gcif.vls.data.remote

import com.jcdecaux.gcif.vls.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author cherif
 * @since 03/11/17.
 */
class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()

        val url = origin.url()
                .newBuilder()
                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                .build()

        val request = origin.newBuilder()
                .url(url)
                .build()

        return chain.proceed(request)
    }
}