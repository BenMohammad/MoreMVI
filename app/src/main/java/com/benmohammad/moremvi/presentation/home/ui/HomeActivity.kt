package com.benmohammad.moremvi.presentation.home.ui

import com.benmohammad.moremvi.presentation.common.BaseActivity
import com.benmohammad.moremvi.presentation.home.HomeAction
import com.benmohammad.moremvi.presentation.home.HomeIntent
import com.benmohammad.moremvi.presentation.home.HomeState
import com.benmohammad.moremvi.presentation.home.HomeViewModel

class HomeActivity
    : BaseActivity<HomeIntent, HomeAction, HomeState, HomeViewModel>(HomeViewModel::class.java){

    private val adapter = CharactersAdapter()


    override fun render(state: HomeState) {
        TODO("Not yet implemented")
    }

    override fun getLayoutResId(): Int {
        TODO("Not yet implemented")
    }

    override fun initUI() {
        TODO("Not yet implemented")
    }

    override fun initDATA() {
        TODO("Not yet implemented")
    }

    override fun initEVENT() {
        TODO("Not yet implemented")
    }
}