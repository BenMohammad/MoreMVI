package com.benmohammad.moremvi.presentation.home

import com.benmohammad.moremvi.presentation.common.ViewAction

sealed class HomeAction: ViewAction {
    data class SearchCharacters(val name: String): HomeAction()
    object AllCharacters : HomeAction()
}
