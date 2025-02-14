package com.donealo.donealoapp.data.usecases

import com.donealo.donealoapp.data.modelo.Donacion
import com.donealo.donealoapp.data.repositorio.DonacionRepositorio

class ObtenerDonacionesUseCase(private val donacionRepositorio: DonacionRepositorio) {
    fun ejecutar(): List<Donacion> {
        return donacionRepositorio.obtenerDonaciones()
    }
}
