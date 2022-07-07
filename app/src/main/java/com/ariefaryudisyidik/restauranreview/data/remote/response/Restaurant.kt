package com.ariefaryudisyidik.restauranreview.data.remote.response

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val city: String,
    val address: String,
    val pictureId: String,
    val rating: Double,
    val categories: List<Category>,
    val menus: Menus,
    val customerReviews: List<CustomerReview>
)