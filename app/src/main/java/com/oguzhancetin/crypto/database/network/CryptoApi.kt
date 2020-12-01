package com.oguzhancetin.crypto.database.network

import com.oguzhancetin.crypto.model.Crypto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL ="https://api.nomics.com/v1/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface CryptoAPI{

    @GET("currencies/ticker?key=8f2891b5daa55e734c33234c8a9003e3&interval=1d,30d")
    suspend fun getAllCurrencies(@Query("convert") type:String): Response<List<Crypto>>
}

object CryptoAPIService{


    fun getRetrofit(): CryptoAPI{
        return retrofit.create(CryptoAPI::class.java)
    }
}