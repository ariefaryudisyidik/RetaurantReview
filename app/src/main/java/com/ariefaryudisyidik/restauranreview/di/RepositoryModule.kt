package com.ariefaryudisyidik.restauranreview.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.ariefaryudisyidik.restauranreview.data.remote.RestaurantApi
import com.ariefaryudisyidik.restauranreview.data.repository.RestaurantRepositoryImpl
import com.ariefaryudisyidik.restauranreview.domain.repository.RestaurantRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRestaurantRepository(api: RestaurantApi): RestaurantRepository =
        RestaurantRepositoryImpl(api)
}