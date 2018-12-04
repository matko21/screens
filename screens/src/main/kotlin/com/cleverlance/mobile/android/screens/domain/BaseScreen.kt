package com.cleverlance.mobile.android.screens.domain

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

abstract class BaseScreen : Screen() {

    lateinit var dispose: Disposable
    protected open val onAfterShow: (() -> Unit)? = null
    protected open val onAfterDisposed: (() -> Unit)? = null

    fun onShow(dispose: Disposable) {
        this.dispose = CompositeDisposable(
            dispose,
            Disposables.fromAction { onAfterDisposed?.invoke() }
        )
        onAfterShow?.invoke()
    }

    /** @return true if back action was consumed by the call */
    open fun onBackPressed(): Boolean {
        dispose.dispose()
        return true
    }
}