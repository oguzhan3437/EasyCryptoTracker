package com.oguzhancetin.crypto.overview

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.work.*
import com.oguzhancetin.crypto.R
import com.oguzhancetin.crypto.adapter.ItemClickListener
import com.oguzhancetin.crypto.adapter.RecyclerviewAdapter
import com.oguzhancetin.crypto.database.network.CryptoAPIService
import com.oguzhancetin.crypto.databinding.FragmentOverviewBinding
import java.sql.Time


class OverviewFragment : Fragment() {
    val overViewViewModelFactory: OverViewViewModelFactory by lazy {
        OverViewViewModelFactory(requireActivity().application, CryptoAPIService.getRetrofit())
    }
    val overviewViewModel: OverviewViewModel by lazy { ViewModelProvider(this,overViewViewModelFactory).get(OverviewViewModel::class.java)}

    val rcAdapter = RecyclerviewAdapter(ItemClickListener {

        val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it)
        Log.e("tıklandı",it.name+"dsadas")
        requireView().findNavController().navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.rectclerView.adapter = rcAdapter
        binding.lifecycleOwner = this
        overviewViewModel.allCurrency.observe(viewLifecycleOwner, Observer {
            it?.let {
                it.forEach {
                    Log.e("logo",it.logo_url)}
               rcAdapter.submitList(it)
            }
        })
        Log.e("deneme","21")

/*
        val workRequest: WorkRequest = OneTimeWorkRequestBuilder<Myworker>().build()
        WorkManager.getInstance(requireContext()).enqueue(workRequest)*/

        return binding.root
    }


}

class Myworker(context: Context,workerParameters: WorkerParameters) : Worker(context,workerParameters){
    override fun doWork(): Result {
        Log.e("dowork","worker")
        return Result.success()
    }

}