package com.donealo.donealoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Modelo de datos
data class Donacion(
    val id: Int,
    val nombre: String,
    val descripcion: String
)

class DonacionViewModel : ViewModel() {
    private val _donaciones = MutableStateFlow<List<Donacion>>(emptyList())
    val donaciones: StateFlow<List<Donacion>> = _donaciones.asStateFlow()

    init {
        cargarDonacionesIniciales()
    }

    private fun cargarDonacionesIniciales() {
        viewModelScope.launch {
            _donaciones.value = listOf(
                Donacion(1, "Ropa de Invierno", "Abrigos y bufandas para el frío"),
                Donacion(2, "Libros Usados", "Libros en buen estado para donar"),
                Donacion(3, "Juguetes", "Juguetes para niños de todas las edades")
            )
        }
    }

    fun agregarDonacion(nombre: String, descripcion: String) {
        val nuevaDonacion = Donacion(id = _donaciones.value.size + 1, nombre, descripcion)
        _donaciones.value = _donaciones.value + nuevaDonacion
    }
}
