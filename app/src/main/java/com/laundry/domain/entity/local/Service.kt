package com.laundry.domain.entity.local

data class Service (
    val id:Int,
    val orderNumber:Int,
    val quantity:Int,
    val data: String,
    val price: Int
)