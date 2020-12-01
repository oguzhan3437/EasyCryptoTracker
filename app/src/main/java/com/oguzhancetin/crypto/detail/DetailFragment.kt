package com.oguzhancetin.crypto.detail


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.oguzhancetin.crypto.R
import com.oguzhancetin.crypto.databinding.DetailFragmentBinding
import com.oguzhancetin.crypto.model.Crypto


class DetailFragment : Fragment() {
    private lateinit var chart:LineChart

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: DetailFragmentBinding = DetailFragmentBinding.inflate(inflater)
        chart= view.chart

        return view.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val currentCrpto = (arguments?.getParcelable<Crypto>("crypto"))

        currentCrpto?.let {
            val viewModelFactory = DetailViewModelFactory(
                requireActivity().application,
                currentCrpto
            )
            viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

            val m1 = currentCrpto.d1
            val m30 = currentCrpto.d30

            val entries = ArrayList<Entry>()

            /*
            val e1 = Entry(1f,m1.price_change.toFloat())
            val e2 = Entry(30f,m30.price_change.toFloat())

             */
            val e1 = Entry(0f,100f)
            val e2 = Entry(1f,50f)
            val e3 = Entry(2f,12f)
            val e4 = Entry(3f,26f)
            val e5 = Entry(4f,13f)
            val e6 = Entry(5f,10f)
            val e7 = Entry(6f,30f)
            entries.add(e1)
            entries.add(e2)
            entries.add(e3)
            entries.add(e4)
            entries.add(e5)
            entries.add(e6)
            entries.add(e7)

            val xLabels = listOf<String>("pts","sal","car","per","cum","cmt,","pzr")



            val formatter = object : ValueFormatter() {
                override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                    return xLabels.getOrNull(value.toInt()) ?: value.toString()
                }
            }
             chart.xAxis.apply {
                valueFormatter = formatter
            }



            val dataset = LineDataSet(entries,"price change")
            dataset.color = ResourcesCompat.getColor(resources,R.color.red,null)
            dataset.valueTextColor = ResourcesCompat.getColor(resources,R.color.red,null)

            val lineData = LineData(dataset)
            chart.data = lineData
            chart.invalidate()

        }


    }

}