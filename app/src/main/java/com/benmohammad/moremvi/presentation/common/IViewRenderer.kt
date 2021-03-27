package com.benmohammad.moremvi.presentation.common

interface IViewRenderer<STATE> {

    fun render(state: STATE)
}
