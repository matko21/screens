package com.cleverlance.mobile.android.screens.presenter

import com.cleverlance.mobile.android.screens.domain.BaseScreen
import com.cleverlance.mobile.android.screens.domain.NoScreen
import com.cleverlance.mobile.android.screens.domain.ScreenFactory
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables

class ScreenPresenter {
    private val screen: BehaviorRelay<BaseScreen> = BehaviorRelay.createDefault(NoScreen())

    fun back(): Boolean = screen.value!!.onBackPressed()

    // TODO pass NoScreen or not?
    fun screenObservable(): Observable<BaseScreen> = screen.filter { it !is NoScreen }

    fun setScreen(screen: BaseScreen) = this.screen.accept(screen)

    fun ensureFirstScreen(invoker: ScreenFactory) {
        if (screen.value is NoScreen) setScreen(invoker.createScreen())
    }

    fun onDisposeShowCurrent(): Disposable {
        val previousScreen = screen.value!!
        return Disposables.fromRunnable { setScreen(previousScreen) }
    }
}
