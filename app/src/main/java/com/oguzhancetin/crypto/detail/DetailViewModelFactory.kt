package com.oguzhancetin.crypto.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oguzhancetin.crypto.model.Crypto
import java.lang.IllegalArgumentException

class DetailViewModelFactory(val application: Application,val crypto: Crypto) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(application,crypto) as T
        }
        throw IllegalArgumentException("invalid class")
    }
}