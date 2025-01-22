package com.donealo.donealoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SeccionJuguetes(navController: NavController) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sección de Juguetes",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Aquí puedes donar o encontrar juguetes que otros ya no necesitan.",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Establecer un tamaño fijo para las imágenes
            val imageSize = 200.dp

            Image(
                painter = painterResource(id = R.drawable.juguete_1),
                contentDescription = "Imagen de Juguetes",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Osito de peluche",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.juguete_2),
                contentDescription = "Imagen de Juguetes",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Tren de juguete",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.juguete_3),
                contentDescription = "Imagen de Juguetes",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Pelota de baloncesto",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.juguete_4),
                contentDescription = "Imagen de Juguetes",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Coche a pedales",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.juguete_5),
                contentDescription = "Imagen de Juguetes",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Diana",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }


        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Volver a Home")
        }
    }
}
