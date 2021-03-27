package com.benmohammad.moremvi.data.services

import com.benmohammad.moremvi.data.common.KEY_NAME
import com.benmohammad.moremvi.data.common.PATH_CHARACTER
import com.benmohammad.moremvi.domain.dto.ECharacter
import com.benmohammad.moremvi.domain.dto.ECharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(PATH_CHARACTER)
    suspend fun getAllCharacters(): Response<ECharacters>

    @GET(PATH_CHARACTER)
    suspend fun searchCharactersByName(@Query(KEY_NAME) name: String): Response<ECharacters>
}