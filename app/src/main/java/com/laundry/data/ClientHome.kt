package com.laundry.data

import com.laundry.R
import com.laundry.domain.HomeClient

data class ClientHome(
    var list: List<HomeClient> = listOf(
        HomeClient(0, R.drawable.ic_iron, "Ironing", 0),
        HomeClient(1,  R.drawable.ic_washer_mashin, "Wash and Iron", 0),
        HomeClient(2, R.drawable.ic_dry, "Dry Cleaning", 0),

    )
)