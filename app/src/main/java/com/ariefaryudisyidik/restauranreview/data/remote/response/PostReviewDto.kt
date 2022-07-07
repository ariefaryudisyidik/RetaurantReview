package com.ariefaryudisyidik.restauranreview.data.remote.response

import com.ariefaryudisyidik.restauranreview.domain.model.CustomerReview

data class PostReviewDto(
    val error: Boolean,
    val message: String,
    val customerReviews: List<CustomerReview>
)

fun PostReviewDto.toDomain() =
    CustomerReview(
        name = customerReviews.map { it.name }.toString(),
        review = customerReviews.map { it.review }.toString()
    )

