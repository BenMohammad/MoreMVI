package com.benmohammad.moremvi.presentation.home.ui

import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.benmohammad.moremvi.R
import com.benmohammad.moremvi.presentation.common.BaseActivity
import com.benmohammad.moremvi.presentation.common.getMessage
import com.benmohammad.moremvi.presentation.common.runIfTrue
import com.benmohammad.moremvi.presentation.home.HomeAction
import com.benmohammad.moremvi.presentation.home.HomeIntent
import com.benmohammad.moremvi.presentation.home.HomeState
import com.benmohammad.moremvi.presentation.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity
    : BaseActivity<HomeIntent, HomeAction, HomeState, HomeViewModel>(HomeViewModel::class.java){

    private val adapter = CharactersAdapter()


    override fun render(state: HomeState) {
        homeProgress.isVisible = state is HomeState.Loading
        homeProgress.isVisible = state is HomeState.Exception
        homeListCharacters.isVisible =
                state is HomeState.ResultSearch || state is HomeState.ResultAllPersona

        when (state) {
            is HomeState.ResultAllPersona -> {
                adapter.updateList(state.data)
            }
            is HomeState.ResultSearch -> {
                adapter.updateList(state.data)
            }

            is HomeState.Exception -> {
                homeMessage.text = state.callErrors.getMessage(this)
            }
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        homeListCharacters.adapter = adapter
    }

    override fun initDATA() {
        dispatchIntent(HomeIntent.LoadAllCharacters)
    }

    override fun initEVENT() {
        homeSearchImage.setOnClickListener {
            homeSearchText.text.isNullOrBlank().runIfTrue {
                dispatchIntent(HomeIntent.SearchCharacter(homeSearchText.text.toString()))
            }
        }
        homeSearchText.doOnTextChanged { text, start, before, count ->
            text.isNullOrBlank()
                    .and(mState is HomeState.ResultSearch)
                    .runIfTrue {
                        dispatchIntent(HomeIntent.ClearSearch)
                    }
        }
    }
}