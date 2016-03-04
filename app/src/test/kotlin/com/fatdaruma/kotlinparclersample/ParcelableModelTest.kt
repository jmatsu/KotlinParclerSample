package com.fatdaruma.kotlinparclersample

import android.os.Bundle
import com.taroid.knit.should
import org.junit.Test
import org.junit.runner.RunWith
import org.parceler.Parcels
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

/**
 * Created by jmatsu on 2016/03/05.
 */
@RunWith(RobolectricGradleTestRunner::class)
@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
class ParcelableModelTest {

    @Test
    fun test_Parcel() {
        val model = ParcelableModel(
                id = 10,
                name = "model",
                body = "this is a body"
        )

        with (Bundle()) {
            putParcelable("parcel", Parcels.wrap(model))
        }
    }

    @Test
    fun test_Unparcel() {
        val model = ParcelableModel(
                id = 10,
                name = "model",
                body = "this is a body"
        )

        val unparceled: ParcelableModel = Bundle().apply {
            putParcelable("key", Parcels.wrap(model))
        }.run {
            Parcels.unwrap(getParcelable("key"))
        }

        unparceled.should be model
    }
}