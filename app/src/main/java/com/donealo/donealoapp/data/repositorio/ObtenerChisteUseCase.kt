package com.donealo.donealoapp.data.usecases

import com.donealo.donealoapp.data.repositorio.ChistesRepositorio

class ObtenerChisteUseCase(private val chistesRepositorio: ChistesRepositorio) {
    suspend fun ejecutar(): String {
        return chistesRepositorio.obtenerChiste()
    }
}

