package com.ariefaryudisyidik.restauranreview.domain.repository

import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.data.remote.response.PostReviewDto
import com.ariefaryudisyidik.restauranreview.data.remote.response.RestaurantDetailDto

interface RestaurantRepository {

    suspend fun getRestaurantDetail(id: String): RestaurantDetailDto

    suspend fun postReview(review: ReviewRequest): PostReviewDto
}