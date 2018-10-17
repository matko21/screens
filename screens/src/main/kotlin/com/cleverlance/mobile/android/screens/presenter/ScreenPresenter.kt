package com.cleverlance.mobile.android.screens.presenter

import com.cleverlance.mobile.android.screens.domain.BaseScreen
import com.cleverlance.mobile.android.screens.domain.NoScreen
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

class ScreenPresenter : BaseScreenPresenter<BaseScreen>() {
    override val screenRelay: BehaviorRelay<BaseScreen> = BehaviorRelay.createDefault(NoScreen())

    fun back(): Boolean = screen.onBackPressed()

    fun screenObservable(): Observable<BaseScreen> = screenRelay
}
