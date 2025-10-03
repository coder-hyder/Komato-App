package com.example.komatoapp.domain.models

import androidx.annotation.DrawableRes

data class RestaurantPromotion(
    @DrawableRes val imageRes:Int,
    val name:String,
    val tagline:String,
    val discount:String
)
