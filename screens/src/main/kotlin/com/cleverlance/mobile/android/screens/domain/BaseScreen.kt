package com.cleverlance.mobile.android.screens.domain

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseScreen : Screen() {

    lateinit var dispose: CompositeDisposable

    fun onShow(dispose: Disposable) {
        this.dispose = CompositeDisposable(dispose)
    }

    /** @return true if back action was consumed by the call */
    open fun onBackPressed(): Boolean {
        dispose.dispose()
        return true
    }
}