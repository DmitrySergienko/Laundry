package com.laundry.data

import com.laundry.domain.Service

data class ServiceOrder(
    var list: List<Service> = listOf(
        Service(0,1,30,"12 Jul",100),
        Service(1,2,5,"12 Jul",100),
        Service(2,3,8,"12 Jul",100),
        Service(3,4,18,"13 Jul",100),
        Service(4,5,6,"13 Jul",100),
        Service(5,6,3,"13 Jul",100),
    )
)
