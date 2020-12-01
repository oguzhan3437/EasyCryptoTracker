package com.oguzhancetin.crypto.util

import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import com.oguzhancetin.crypto.R
import com.oguzhancetin.crypto.model.Crypto

import java.net.URI

//set image
@BindingAdapter("setCryptoImage")
fun ImageView.cryptoImage(crypto: Crypto){
    var url = crypto.logo_url
    if(url.endsWith("svg",true)){
        Log.e("son","svg")
        var uri:Uri = Uri.parse(url)

        GlideToVectorYou
            .init()
            .with(context)
            .withListener(object : GlideToVectorYouListener {
                override fun onLoadFailed() {
                    Log.e("fail","fail")
                }

                override fun onResourceReady() {

                }

            })
            .load(uri,this)
    }else{
        Glide
            .with(this)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("priceChange")
fun TextView.priceChange(crypto: Crypto){

    crypto.d1?.let {
        val priceChange1d = ((it.price_change + crypto?.price)/(crypto?.price)).toString()

        if(crypto.d1.toString().contains("-")){
            text = priceChange1d
            setTextColor(resources.getColor(R.color.red))
        }else{
            text = priceChange1d
            setTextColor(resources.getColor(R.color.green))
        }
    }

}
