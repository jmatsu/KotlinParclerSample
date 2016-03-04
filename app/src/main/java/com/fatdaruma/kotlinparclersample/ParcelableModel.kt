package com.fatdaruma.kotlinparclersample

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

/**
 * Created by jmatsu on 2016/03/05.
 */

@Parcel
data class ParcelableModel @ParcelConstructor constructor(

        @ParcelProperty("id")
        val id: Int,

        @ParcelProperty("name")
        val name: String,

        @ParcelProperty("body")
        val body: String
)