package com.benmohammad.moremvi.data.managers

import com.benmohammad.moremvi.data.common.Result
import com.benmohammad.moremvi.domain.entity.Persona
import kotlinx.coroutines.flow.Flow

interface CharactersManager {
    fun getAllCharacters(): Flow<Result<List<Persona>>>
    fun searchCharacters(name: String): Flow<Result<List<Persona>>>
}