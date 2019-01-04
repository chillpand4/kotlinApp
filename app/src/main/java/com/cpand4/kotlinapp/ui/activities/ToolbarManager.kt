package com.cpand4.kotlinapp.ui.activities

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.cpand4.kotlinapp.R
import com.cpand4.kotlinapp.extensions.ctx
import com.cpand4.kotlinapp.extensions.slideEnter
import com.cpand4.kotlinapp.extensions.slideExit
import com.cpand4.kotlinapp.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by stefano on 04/01/2019.
 */

interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_settings -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unkown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() =
            DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}