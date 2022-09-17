package com.laundry.data

import com.laundry.R
import com.laundry.domain.Category

data class CategoryList(
    var  fakeItemList: List<Category> = listOf<Category>(
        Category(R.drawable.ic_checkbox_image_one,"Shorts",3),
        Category(R.drawable.ic_checkbox_image_two,"Cardigan",2),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_t_shirt,"T-Shirt",3),
        Category(R.drawable.ic_checkbox_other,"Other",3),
        Category(R.drawable.ic_checkbox_image_one,"Shorts",3),
        Category(R.drawable.ic_checkbox_image_two,"Cardigan",2),
        Category(R.drawable.ic_checkbox_image_three,"Skirt",3),
        Category(R.drawable.ic_checkbox_t_shirt,"T-Shirt",3),
        Category(R.drawable.ic_checkbox_other,"Other",3),
    )
)
