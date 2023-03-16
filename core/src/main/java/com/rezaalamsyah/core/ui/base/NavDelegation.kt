package com.rezaalamsyah.core.ui.base

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import javax.inject.Inject

class NavDelegation: NavDelegate {
    private lateinit var nav: NavController

    override fun registerController(controller: NavController) {
        nav = controller
    }

    override fun navigate(resId: Int, args: Bundle?, navOptions: NavOptions?) {
        nav.navigate(resId, args, navOptions)
    }
}