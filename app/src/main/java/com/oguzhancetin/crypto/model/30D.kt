package com.oguzhancetin.crypto.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Keep
@Parcelize
data class D30(
    @Expose
    @SerializedName("volume")
    val volume : Double,
    @Expose
    @SerializedName("price_change")
    val price_change : Double,
    @Expose
    @SerializedName("price_change_pct")
    val price_change_pct : Double,
    @Expose
    @SerializedName("volume_change")
    val volume_change : Double,
    @Expose
    @SerializedName("volume_change_pct")
    val volume_change_pct : Double,
    @Expose
    @SerializedName("market_cap_change")
    val market_cap_change : Double,
    @Expose
    @SerializedName("market_cap_change_pct")
    val market_cap_change_pct : Double
) : Parcelable
