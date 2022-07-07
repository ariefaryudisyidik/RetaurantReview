package com.ariefaryudisyidik.restauranreview.domain.usecase.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ariefaryudisyidik.restauranreview.data.remote.response.toDomain
import com.ariefaryudisyidik.restauranreview.domain.model.Restaurant
import com.ariefaryudisyidik.restauranreview.domain.repository.RestaurantRepository
import com.ariefaryudisyidik.restauranreview.utils.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRestaurantDetailUseCase @Inject constructor(
    private val repository: RestaurantRepository
) {
    operator fun invoke(id: String): LiveData<Resource<Restaurant>> = liveData {
        try {
            emit(Resource.Loading())
            val restaurant = repository.getRestaurantDetail(id).toDomain()
            emit(Resource.Success(restaurant))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage!!))
        } catch (e: IOException) {
            emit(Resource.Error("No Internet Connection"))
        }
    }
}