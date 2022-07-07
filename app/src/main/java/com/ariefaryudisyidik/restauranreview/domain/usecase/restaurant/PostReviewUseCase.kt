package com.ariefaryudisyidik.restauranreview.domain.usecase.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.data.remote.response.toDomain
import com.ariefaryudisyidik.restauranreview.domain.model.CustomerReview
import com.ariefaryudisyidik.restauranreview.domain.repository.RestaurantRepository
import com.ariefaryudisyidik.restauranreview.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostReviewUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(review: ReviewRequest): LiveData<Resource<CustomerReview>> = liveData {
        try {
            emit(Resource.Loading())
            val customerReview = repository.postReview(review).toDomain()
            emit(Resource.Success(customerReview))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage!!))
        } catch (e: IOException) {
            emit(Resource.Error("No Internet Connection"))
        }
    }
}