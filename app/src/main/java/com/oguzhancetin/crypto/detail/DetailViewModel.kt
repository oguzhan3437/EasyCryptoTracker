package com.oguzhancetin.crypto.detail

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzhancetin.crypto.model.Crypto

class DetailViewModel(application: Application,crypto: Crypto) : AndroidViewModel(application) {
    private val _min1 = MutableLiveData<Double>()
    val min1:LiveData<Double>
        get() = min1
    private val _min30= MutableLiveData<Double>()
    val min30:LiveData<Double>
        get() = min30

    init {
        _min1.value = crypto.d1.price_change
    }
}