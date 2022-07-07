package com.ariefaryudisyidik.restauranreview.data.repository

import com.ariefaryudisyidik.restauranreview.data.remote.RestaurantApi
import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.domain.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val api: RestaurantApi
) : RestaurantRepository {

    override suspend fun getRestaurantDetail(id: String) = api.getRestaurantDetail(id)

    override suspend fun postReview(review: ReviewRequest) = api.postReview(review)
}