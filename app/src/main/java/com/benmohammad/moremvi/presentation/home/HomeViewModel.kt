package com.benmohammad.moremvi.presentation.home

import com.benmohammad.moremvi.data.managers.CharactersManager
import com.benmohammad.moremvi.presentation.common.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val dataManager: CharactersManager)
    : BaseViewModel<HomeIntent, HomeAction, HomeState>() {

    override fun intentToAction(intent: HomeIntent): HomeAction {
        return when(intent) {
            is HomeIntent.LoadAllCharacters ->HomeAction.AllCharacters
            is HomeIntent.ClearSearch -> HomeAction.AllCharacters
            is HomeIntent.SearchCharacter -> HomeAction.SearchCharacters(intent.name)
        }
    }

    override fun handleAction(action: HomeAction) {
        launchOnUI {
            when (action) {
                is HomeAction.AllCharacters -> {
                    dataManager.getAllCharacters().collect {
                        mState.postValue(it.reduce())
                    }
                }
                is HomeAction.SearchCharacters -> {
                    dataManager.searchCharacters(action.name).collect {
                        mState.postValue(it.reduce(true))
                    }
                }
            }
        }
    }
}