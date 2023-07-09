package com.kareem.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Named

class NetworkInterceptor @Inject constructor(@Named("ApiAccessToken") val token: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("accept", "application/json")
        requestBuilder.addHeader("Authorization", "Bearer $token")

        return chain.proceed(requestBuilder.build())
    }
}