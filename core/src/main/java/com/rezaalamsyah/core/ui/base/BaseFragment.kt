package com.rezaalamsyah.core.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment(), NavDelegate by NavDelegation(), IBaseView {

    private lateinit var currentActivity: BaseActivity

    val hostController by lazy { currentActivity.getController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerController(findNavController())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSetView()
        onSetAction()
        onSetObserver()
    }

    override fun setToolbar(
        toolbar: Toolbar?,
        title: String?,
        isChild: Boolean,
        menu: Int?,
        onMenuAction: ((Int) -> Boolean)?
    ) {
        currentActivity.setToolbar(toolbar, title, isChild, menu, onMenuAction)
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            currentActivity = when (context) {
                is BaseActivity -> context
                else -> (context as BaseFragment).currentActivity
            }
        } catch (t: Throwable) {
            Log.e("FragmentException: ", "${t.message}")
        }
    }

    open fun onSetView() {}
    open fun onSetAction() {}
    open fun onSetObserver() {}
}