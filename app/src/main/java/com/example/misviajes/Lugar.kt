package com.example.misviajes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lugar (val nombre:String,val foto:String,
                 val lat:String,val lon:String) :Parcelable{}
