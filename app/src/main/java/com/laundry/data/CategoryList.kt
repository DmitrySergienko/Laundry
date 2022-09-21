package com.laundry.data

import com.laundry.R
import com.laundry.domain.Category

data class CategoryList(
    var  list: List<Category> = listOf<Category>(
        Category(0,false,R.drawable.ic_checkbox_image_one,"Shorts",3),
        Category(1,false,R.drawable.ic_checkbox_image_two,"Cardigan",2),
        Category(2,false,R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(3,false,R.drawable.ic_checkbox_t_shirt,"T-Shirt",3),
        Category(4,false,R.drawable.ic_checkbox_other,"Other",3),
        Category(5,false,R.drawable.ic_checkbox_image_one,"Shorts",3),
        Category(6,false,R.drawable.ic_checkbox_image_two,"Cardigan",2),
        Category(7,false,R.drawable.ic_checkbox_image_three,"Skirt",3),
    )
)
