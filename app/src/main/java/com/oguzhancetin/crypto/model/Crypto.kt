package com.oguzhancetin.crypto.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Crypto(

    @Expose
    @SerializedName("id")
    val id : String,
    @Expose
    @SerializedName("currency")
    val currency : String,
    @Expose
    @SerializedName("symbol")
    val symbol : String,
    @Expose
    @SerializedName("name")
    val name : String,
    @Expose
    @SerializedName("logo_url")
    val logo_url : String,
    @Expose
    @SerializedName("price")
    val price : Double,
    @Expose
    @SerializedName("price_date")
    val price_date : String,
    @Expose
    @SerializedName("price_timestamp")
    val price_timestamp : String,
    @Expose
    @SerializedName("circulating_supply")
    val circulating_supply : Double,
    @Expose
    @SerializedName("max_supply")
    val max_supply : Double,
    @Expose
    @SerializedName("market_cap")
    val market_cap : Double,
    @Expose
    @SerializedName("rank")
    val rank : Double,
    @Expose
    @SerializedName("high")
    val high : Double,
    @Expose
    @SerializedName("high_timestamp")
    val high_timestamp : String,
    @Expose
    @SerializedName("1d")
    val d1 : D1,
    @Expose
    @SerializedName("30d")
    val d30 : D30
) : Parcelable

