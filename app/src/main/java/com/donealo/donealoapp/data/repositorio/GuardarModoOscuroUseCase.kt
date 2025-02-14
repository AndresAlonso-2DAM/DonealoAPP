package com.donealo.donealoapp.data.usecases

import com.donealo.donealoapp.data.repositorio.PreferenciasRepositorio

class GuardarModoOscuroUseCase(private val preferenciasRepositorio: PreferenciasRepositorio) {
    fun ejecutar(activado: Boolean) {
        preferenciasRepositorio.guardarModoOscuro(activado)
    }
}
