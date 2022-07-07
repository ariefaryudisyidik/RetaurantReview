package com.ariefaryudisyidik.restauranreview.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.domain.usecase.restaurant.GetRestaurantDetailUseCase
import com.ariefaryudisyidik.restauranreview.domain.usecase.restaurant.PostReviewUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRestaurantDetailUseCase: GetRestaurantDetailUseCase,
    private val postReviewUseCase: PostReviewUseCase,
) : ViewModel() {

    fun getRestaurantDetail(id: String) = getRestaurantDetailUseCase(id)

    fun postReview(review: ReviewRequest) = postReviewUseCase(review)
}