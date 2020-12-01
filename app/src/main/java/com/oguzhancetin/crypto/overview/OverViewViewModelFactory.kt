package com.oguzhancetin.crypto.overview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oguzhancetin.crypto.database.network.CryptoAPI
import java.lang.IllegalArgumentException

class OverViewViewModelFactory(val application: Application,val cryptoAPI: CryptoAPI) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OverviewViewModel::class.java)){
            return (OverviewViewModel(application,cryptoAPI) as T)
        }
        throw IllegalArgumentException("invalid class")
    }

}