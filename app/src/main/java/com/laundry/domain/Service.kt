package com.laundry.domain

data class Service (
    val id:Int,
    val orderNumber:Int,
    val quantity:Int,
    val data: String,
    val price: Int
)