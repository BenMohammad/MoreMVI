package com.benmohammad.moremvi.presentation.home

import com.benmohammad.moremvi.presentation.common.ViewIntent
import kotlinx.serialization.descriptors.PrimitiveKind

sealed class HomeIntent: ViewIntent {
    object LoadAllCharacters: HomeIntent()
    data class SearchCharacter(val name: String): HomeIntent()
    object ClearSearch: HomeIntent()
}
