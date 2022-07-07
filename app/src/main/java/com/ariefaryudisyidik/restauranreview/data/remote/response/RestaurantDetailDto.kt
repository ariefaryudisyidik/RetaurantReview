package com.ariefaryudisyidik.restauranreview.data.remote.response

import com.ariefaryudisyidik.restauranreview.domain.model.Restaurant

data class RestaurantDetailDto(
    val error: Boolean,
    val message: String,
    val restaurant: Restaurant
)

fun RestaurantDetailDto.toDomain() =
    Restaurant(
        id = restaurant.id,
        name = restaurant.name,
        description = restaurant.description,
        pictureId = restaurant.pictureId,
        customerReviews = restaurant.customerReviews
    )

