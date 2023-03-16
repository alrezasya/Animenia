package com.rezaalamsyah.core.ui.base

import androidx.appcompat.widget.Toolbar

interface IBaseView {
    fun setToolbar(
        toolbar: Toolbar? = null,
        title: String? = null,
        isChild: Boolean,
        menu: Int? = null,
        onMenuAction: ((Int) -> Boolean)? = null
    )
}