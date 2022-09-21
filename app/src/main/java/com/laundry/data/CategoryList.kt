package com.laundry.data

import com.laundry.R
import com.laundry.data.database.entities.CategoryEntity
import com.laundry.domain.Category

data class CategoryList(
    var  list: List<CategoryEntity> = listOf<CategoryEntity>(
        CategoryEntity(0,false,R.drawable.ic_checkbox_image_one,"Shorts",0),
        CategoryEntity(1,false,R.drawable.ic_checkbox_image_two,"Cardigan",0),
        CategoryEntity(2,false,R.drawable.ic_checkbox_image_three,"Skirt",0),
        CategoryEntity(3,false,R.drawable.ic_checkbox_t_shirt,"T-Shirt",0),
        CategoryEntity(4,false,R.drawable.ic_checkbox_other,"Other",0),
        CategoryEntity(5,false,R.drawable.ic_checkbox_image_one,"Shorts",0),
        CategoryEntity(6,false,R.drawable.ic_checkbox_image_two,"Cardigan",0),
        CategoryEntity(7,false,R.drawable.ic_checkbox_image_three,"Skirt",3),
    )
)
