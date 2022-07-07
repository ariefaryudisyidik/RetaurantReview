package com.ariefaryudisyidik.restauranreview.domain.model

import com.ariefaryudisyidik.restauranreview.data.remote.response.CustomerReview

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val pictureId: String,
    val customerReviews: List<CustomerReview>
)