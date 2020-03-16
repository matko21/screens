package com.cleverlance.mobile.android.screens.view

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import com.cleverlance.mobile.android.screens.domain.Screen
import com.cleverlance.mobile.android.screens.domain.createSelfBindingView

abstract class ScreenPagerAdapter : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): View =
            createScreenContainer(container, getScreen(position))
                    .apply { container.addView(this) } ?: View(container.context)

    abstract fun getScreen(position: Int): Screen

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun isViewFromObject(view: View, any: Any) = view == any

    private fun createScreenContainer(container: ViewGroup, screen: Screen) =
            screen.createSelfBindingView(container, container.context as FragmentActivity)
}