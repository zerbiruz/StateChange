package com.example.statechange

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val Name: String
) : Parcelable
