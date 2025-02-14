package com.donealo.donealoapp

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun PantallaRoom(contexto: Context) {
    val baseDeDatos = BaseDeDatosRoom.obtenerBaseDeDatos(contexto)
    val donacionDAO = baseDeDatos.donacionDAO()
    val donaciones = remember { mutableStateOf(listOf<Donacion>()) }

    LaunchedEffect(Unit) {
        donaciones.value = donacionDAO.obtenerTodasLasDonaciones()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Donaciones guardadas en Room", style = MaterialTheme.typography.headlineMedium)
        donaciones.value.forEach { donacion ->
            Text(text = "${donacion.nombre}: ${donacion.descripcion} (${donacion.categoria})")
        }
    }
}
