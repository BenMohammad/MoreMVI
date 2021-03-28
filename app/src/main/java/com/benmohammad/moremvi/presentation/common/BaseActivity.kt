package com.benmohammad.moremvi.presentation.common

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<INTENT: ViewIntent, ACTION: ViewAction, STATE: ViewState,
        VM: BaseViewModel<INTENT, ACTION, STATE>>(private val modelClass: Class<VM>)
: RootBaseActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE
    val mState get() = viewState




    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun initUI()
    abstract fun initDATA()
    abstract fun initEVENT()


}