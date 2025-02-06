package com.donealo.donealoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DonacionViewModel(private val donacionDAO: DonacionDAO) : ViewModel() {

    private val _donaciones = MutableStateFlow<List<Donacion>>(emptyList())
    val donaciones: StateFlow<List<Donacion>> = _donaciones

    init {
        cargarDonacionesLocales()
        cargarDonacionesDesdeApi()
    }

    private fun cargarDonacionesLocales() {
        viewModelScope.launch {
            _donaciones.value = donacionDAO.obtenerTodasLasDonaciones()
        }
    }

    private fun cargarDonacionesDesdeApi() {
        viewModelScope.launch {
            val response = RetrofitInstancia.api.obtenerDonaciones()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _donaciones.value = it
                    }
                }

        }
    }
}

