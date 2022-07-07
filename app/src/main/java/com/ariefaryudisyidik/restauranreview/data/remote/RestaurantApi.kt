package com.ariefaryudisyidik.restauranreview.data.remote

import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.data.remote.response.PostReviewDto
import com.ariefaryudisyidik.restauranreview.data.remote.response.RestaurantDetailDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestaurantApi {

    @GET("detail/{id}")
    suspend fun getRestaurantDetail(
        @Path("id") id: String
    ): RestaurantDetailDto

    @POST("review")
    suspend fun postReview(
        @Body review: ReviewRequest
    ): PostReviewDto
}