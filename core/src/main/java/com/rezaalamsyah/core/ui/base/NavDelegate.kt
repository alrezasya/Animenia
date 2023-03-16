package com.rezaalamsyah.core.ui.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface NavDelegate {

    fun registerController(controller: NavController)

    fun navigate(@IdRes resId: Int, args: Bundle? = null, navOptions: NavOptions? = null)

}