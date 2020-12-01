package com.oguzhancetin.crypto.overview

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import androidx.work.*
import com.oguzhancetin.crypto.model.Crypto
import com.oguzhancetin.crypto.database.Repository
import com.oguzhancetin.crypto.database.network.CryptoAPI
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit
private val _allCurrency = MutableLiveData<List<Crypto>>()

var viewModelScope: CoroutineScope? = null
private var repository: Repository? = null


class OverviewViewModel(application: Application,cryptoAPI: CryptoAPI) : AndroidViewModel(application) {

    val allCurrency:LiveData<List<Crypto>>
        get() = _allCurrency

    init {
        com.oguzhancetin.crypto.overview.viewModelScope = viewModelScope
        repository = Repository(cryptoAPI)
        val downloadData: PeriodicWorkRequest = PeriodicWorkRequestBuilder<UpdateDataWorker>(15,TimeUnit.MINUTES)
            .build()
        val downloadDataFirst= OneTimeWorkRequestBuilder<UpdateDataWorker>()
            .build()

        WorkManager.getInstance(getApplication() as Application).enqueue(downloadDataFirst)
    }

    /*
    initialize to pull all data
     */
    private fun initialize() {

    }



    class UpdateDataWorker(context: Context,workerParameters: WorkerParameters): Worker(context,workerParameters){
        override fun doWork(): Result {
            Log.e("wokr","calıstı")
            viewModelScope?.launch() {
                val data = viewModelScope?.async(Dispatchers.IO) {
                    repository?.getAllCrypto()

                }
                withContext(Dispatchers.Main){
                    _allCurrency.value = data?.await()
                }
            }

            return Result.success()
        }


    }



}
