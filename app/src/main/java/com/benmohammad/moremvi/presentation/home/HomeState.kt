package com.benmohammad.moremvi.presentation.home

import com.benmohammad.moremvi.data.common.CallErrors
import com.benmohammad.moremvi.domain.entity.Persona
import com.benmohammad.moremvi.presentation.common.ViewState

sealed class HomeState :ViewState {
    object Loading: HomeState()
    data class ResultAllPersona(val data: List<Persona>): HomeState()
    data class ResultSearch(val data: List<Persona>): HomeState()
    data class Exception(val callErrors: CallErrors): HomeState()
}
