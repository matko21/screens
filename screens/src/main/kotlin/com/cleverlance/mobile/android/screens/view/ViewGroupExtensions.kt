package com.cleverlance.mobile.android.screens.view

import android.app.Activity
import android.view.ViewGroup
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.cleverlance.mobile.android.screens.domain.Screen
import com.cleverlance.mobile.android.screens.domain.createSelfBindingView

fun ViewGroup.setScreen(screen: Screen, transaction: Transition? = null) {
    screen.createSelfBindingView(this, context as Activity)?.let {
        TransitionManager.go(Scene(this, it), transaction)
    }
}

fun ViewGroup.addScreen(screen: Screen) {
    screen.createSelfBindingView(this, context as Activity)?.let { addView(it) }
}