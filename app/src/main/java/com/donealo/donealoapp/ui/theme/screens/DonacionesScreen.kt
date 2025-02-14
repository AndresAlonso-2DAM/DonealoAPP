package com.donealo.donealoapp.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.donealo.donealoapp.ui.viewmodel.DonacionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonacionesScreen(navController: NavController, viewModel: DonacionViewModel = viewModel()) {
    val donaciones by viewModel.donaciones.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Donaciones") }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    items(donaciones) { donacion ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = donacion.nombre,
                                    style = MaterialTheme.typography.headlineSmall, // Estilo para el nombre
                                    modifier = Modifier.padding(bottom = 8.dp) // Espacio entre el título y la descripción
                                )
                                Text(
                                    text = donacion.descripcion,
                                    style = MaterialTheme.typography.bodyMedium // Estilo para la descripción
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}
