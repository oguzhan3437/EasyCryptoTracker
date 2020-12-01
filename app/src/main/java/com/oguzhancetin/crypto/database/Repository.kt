package com.oguzhancetin.crypto.database

import com.oguzhancetin.crypto.database.network.CryptoAPI
import com.oguzhancetin.crypto.model.Crypto

class Repository(val cryptoAPI: CryptoAPI,){





    suspend fun getAllCrypto() : List<Crypto>? {
        val response = cryptoAPI.getAllCurrencies("EUR")
        var data: List<Crypto>? = null
        if (response.isSuccessful){
            response.body()?.let {
                data = it
            }
        }
        return data
    }

}