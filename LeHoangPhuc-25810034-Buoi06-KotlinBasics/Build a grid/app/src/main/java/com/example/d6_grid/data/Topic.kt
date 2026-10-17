
package com.example.d6_grid.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val courseCount: Int,
    @DrawableRes val imageRes: Int
)