package com.donealo.donealoapp.data.usecases

import com.donealo.donealoapp.data.modelo.Donacion
import com.donealo.donealoapp.data.repositorio.DonacionRepositorio

class AgregarDonacionUseCase(private val donacionRepositorio: DonacionRepositorio) {
    fun ejecutar(donacion: Donacion) {
        donacionRepositorio.insertarDonacion(donacion)
    }
}
