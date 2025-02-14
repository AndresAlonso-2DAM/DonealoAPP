package com.donealo.donealoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donealo.donealoapp.data.usecases.GuardarModoOscuroUseCase
import com.donealo.donealoapp.data.usecases.ObtenerModoOscuroUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PreferenciasViewModel(
    private val obtenerModoOscuroUseCase: ObtenerModoOscuroUseCase,
    private val guardarModoOscuroUseCase: GuardarModoOscuroUseCase
) : ViewModel() {

    private val _modoOscuro = MutableStateFlow(false)
    val modoOscuro: StateFlow<Boolean> = _modoOscuro

    init {
        cargarPreferencias()
    }

    private fun cargarPreferencias() {
        viewModelScope.launch {
            _modoOscuro.value = obtenerModoOscuroUseCase.ejecutar()
        }
    }

    fun cambiarModoOscuro(activado: Boolean) {
        viewModelScope.launch {
            guardarModoOscuroUseCase.ejecutar(activado)
            _modoOscuro.value = activado
        }
    }
}
