package com.donealo.donealoapp.data.usecases

import com.donealo.donealoapp.data.repositorio.PreferenciasRepositorio

class ObtenerModoOscuroUseCase(private val preferenciasRepositorio: PreferenciasRepositorio) {
    fun ejecutar(): Boolean {
        return preferenciasRepositorio.obtenerModoOscuro()
    }
}
