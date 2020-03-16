package com.cleverlance.mobile.android.screens.domain

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.cleverlance.mobile.android.screens.presenter.BasePresenterView
import com.cleverlance.mobile.android.screens.presenter.createSelfBindingView

interface ViewFactory {
    fun createView(): BasePresenterView?
}

internal fun ViewFactory.createSelfBindingView(viewGroup: ViewGroup, activity: FragmentActivity): View? =
        createView()?.createSelfBindingView(viewGroup, activity)
