package com.donealo.donealoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donealo.donealoapp.data.usecases.ObtenerChisteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChistesViewModel(
    private val obtenerChisteUseCase: ObtenerChisteUseCase
) : ViewModel() {

    private val _chiste = MutableStateFlow("Presiona el botón para obtener un chiste")
    val chiste: StateFlow<String> = _chiste

    fun cargarChiste() {
        viewModelScope.launch {
            _chiste.value = obtenerChisteUseCase.ejecutar()
        }
    }
}
