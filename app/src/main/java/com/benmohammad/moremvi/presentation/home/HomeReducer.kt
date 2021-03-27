package com.benmohammad.moremvi.presentation.home

import com.benmohammad.moremvi.data.common.Result
import com.benmohammad.moremvi.domain.entity.Persona

fun Result<List<Persona>>.reduce(isSearchMode: Boolean = false): HomeState {
    return when(this) {
        is Result.Success -> if(isSearchMode) HomeState.ResultSearch(data) else HomeState.ResultAllPersona(data)
        is Result.Error -> HomeState.Exception(exception)
        is Result.Loading -> HomeState.Loading
    }
}