package com.donealo.donealoapp.data.repositorio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ChistesApiService {
    @GET("jokes/random")
    suspend fun obtenerChiste(): ChisteRespuesta
}

data class ChisteRespuesta(val value: String)

class ChistesRepositorio {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ChistesApiService::class.java)

    suspend fun obtenerChiste(): String {
        return try {
            val respuesta = apiService.obtenerChiste()
            respuesta.value
        } catch (e: Exception) {
            "Error al obtener chiste"
        }
    }
}
