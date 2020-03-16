package com.cleverlance.mobile.android.screens.view

import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.cleverlance.mobile.android.screens.domain.Screen
import com.cleverlance.mobile.android.screens.domain.createSelfBindingView

fun ViewGroup.setScreen(screen: Screen, transaction: Transition? = null) {
    screen.createSelfBindingView(this, context as FragmentActivity)?.let {
        TransitionManager.go(Scene(this, it), transaction)
    }
}

fun ViewGroup.addScreen(screen: Screen, activity: FragmentActivity = context as FragmentActivity) {
    screen.createSelfBindingView(this, activity)?.let { addView(it) }
}