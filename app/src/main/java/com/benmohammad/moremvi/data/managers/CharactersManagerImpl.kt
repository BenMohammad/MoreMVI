package com.benmohammad.moremvi.data.managers

import com.benmohammad.moremvi.data.common.CallErrors
import com.benmohammad.moremvi.data.common.Result
import com.benmohammad.moremvi.data.common.applyCommonSideEffects
import com.benmohammad.moremvi.data.services.ApiService
import com.benmohammad.moremvi.domain.dto.toModel
import com.benmohammad.moremvi.domain.entity.Persona
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class CharactersManagerImpl(private val api: ApiService): CharactersManager {

    override fun getAllCharacters(): Flow<Result<List<Persona>>> = flow {
        api.getAllCharacters().run {
            if(this.isSuccessful) {
                if(this.body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    emit(Result.Success(this.body()!!.results.toModel()))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }

    override fun searchCharacters(name: String): Flow<Result<List<Persona>>> = flow {
        api.searchCharactersByName(name)    .run {
            if(this.isSuccessful) {
                if(this.body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    emit(Result.Success(this.body()!!.results.toModel()))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.applyCommonSideEffects().catch {
        emit(Result.Error(CallErrors.ErrorException(it)))
    }
}