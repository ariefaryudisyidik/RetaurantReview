package com.ariefaryudisyidik.restauranreview.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

const val BASE_URL = "https://restaurant-api.dicoding.dev/"
const val PICTURE_URL = "https://restaurant-api.dicoding.dev/images/large/"
const val NAME = "Dicoding"
const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"

fun snackbar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}
