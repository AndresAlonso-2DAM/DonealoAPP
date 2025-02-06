package com.donealo.donealoapp

import com.donealo.donealoapp.Donacion
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface ServicioApi {
    @GET("donaciones")
    suspend fun obtenerDonaciones(): Response<List<Donacion>>
}