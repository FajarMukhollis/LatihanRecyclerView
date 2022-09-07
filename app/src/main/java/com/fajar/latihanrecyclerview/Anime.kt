package com.fajar.latihanrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anime (
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable