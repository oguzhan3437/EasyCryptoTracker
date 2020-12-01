package com.oguzhancetin.crypto


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oguzhancetin.crypto.database.network.CryptoAPIService
import com.oguzhancetin.crypto.overview.OverViewViewModelFactory
import com.oguzhancetin.crypto.overview.OverviewViewModel
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}