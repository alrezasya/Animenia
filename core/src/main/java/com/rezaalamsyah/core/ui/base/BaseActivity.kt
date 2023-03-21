package com.rezaalamsyah.core.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment

abstract class BaseActivity : AppCompatActivity(), IBaseView, IActivityView, NavDelegate by NavDelegation() {

    private var menuId: Int? = null
    private var menuListener: ((Int) -> Boolean)? = null
    private var hostId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        registerController(getController())
    }

    override fun setHost(resId: Int?) {
        this.hostId = resId
    }

    fun getController() =
        (hostId?.let { supportFragmentManager.findFragmentById(it) } as NavHostFragment).navController

    override fun setToolbar(
        toolbar: Toolbar?,
        title: String?,
        isChild: Boolean,
        menu: Int?,
        onMenuAction: ((Int) -> Boolean)?
    ) {
        menuId = menu
        menuListener = onMenuAction
        toolbar?.let {
            setSupportActionBar(it)
            supportActionBar?.let { tb ->
                title?.let { title -> tb.title = title }
                tb.setDisplayHomeAsUpEnabled(isChild)
                invalidateOptionsMenu()
            }
        } ?: run {
            supportActionBar?.let {
                it.title = title
                it.setDisplayHomeAsUpEnabled(isChild)
                invalidateOptionsMenu()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuId?.let { menuInflater.inflate(it, menu) }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        menuListener?.invoke(item.itemId)
        return super.onOptionsItemSelected(item)
    }

}