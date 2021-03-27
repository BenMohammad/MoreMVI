package com.benmohammad.moremvi.presentation.common

import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<INTENT: ViewIntent, ACTION: ViewAction, STATE: ViewState,
        VM: BaseViewModel<INTENT, ACTION, STATE>>(private val modelClass: Class<VM>)
: RootBaseActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE
    val mState get() = viewState


}