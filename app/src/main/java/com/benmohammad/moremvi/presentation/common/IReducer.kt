package com.benmohammad.moremvi.presentation.common

interface IReducer<STATE, T: Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}