package com.ariefaryudisyidik.restauranreview.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import com.ariefaryudisyidik.restauranreview.R
import com.ariefaryudisyidik.restauranreview.data.remote.request.ReviewRequest
import com.ariefaryudisyidik.restauranreview.databinding.ActivityMainBinding
import com.ariefaryudisyidik.restauranreview.domain.model.Restaurant
import com.ariefaryudisyidik.restauranreview.utils.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getRestaurantDetail()
        postCustomerReview()
    }

    private fun getRestaurantDetail() {
        viewModel.getRestaurantDetail(RESTAURANT_ID).observe(this) { result ->
            when (result) {
                is Resource.Loading -> {
                    showLoading(true)
                }
                is Resource.Success -> {
                    showLoading(false)
                    result.data?.let {
                        showRestaurantDetail(it)
                        showCustomerReview(it)
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    result.message?.let { showErrorMessage(it) }
                }
            }
        }
    }

    private fun postCustomerReview() {
        binding.btnSend.setOnClickListener {
            val id = RESTAURANT_ID
            val name = NAME
            val review = binding.edReview.text.toString()
            val reviewRequest = ReviewRequest(id, name, review)
            if (review.isEmpty()) {
                snackbar(binding.root, getString(R.string.empty_review))
            } else {
                viewModel.postReview(reviewRequest).observe(this) { result ->
                    when (result) {
                        is Resource.Loading -> {
                            showLoading(true)
                        }
                        is Resource.Success -> {
                            showLoading(false)
                            getRestaurantDetail()
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            result.message?.let { showErrorMessage(it) }
                        }
                    }
                }
            }

        }
    }

    private fun showRestaurantDetail(restaurant: Restaurant) {
        binding.apply {
            tvTitle.text = restaurant.name
            tvDescription.text = restaurant.description
            Glide.with(this@MainActivity)
                .load(PICTURE_URL + restaurant.pictureId)
                .into(ivPicture)
        }
    }

    private fun showCustomerReview(restaurant: Restaurant) {
        binding.apply {
            val listReview = restaurant.customerReviews.map {
                "${it.review}\n- ${it.name}"
            }
            val adapter = MainAdapter(listReview)
            binding.rvReview.adapter = adapter
            binding.edReview.setText("")
        }
    }

    private fun showLoading(visible: Boolean) {
        binding.progressBar.isVisible = visible
    }

    private fun showErrorMessage(message: String) {
        snackbar(binding.root, message)
    }
}