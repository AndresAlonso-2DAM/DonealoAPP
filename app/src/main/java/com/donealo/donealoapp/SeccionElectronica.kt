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
fun SeccionElectronica(navController: NavController) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        // Contenido scrollable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sección de Electrónica",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Aquí puedes donar o encontrar artículos electrónicos que otros ya no necesitan.",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            val imageSize = 200.dp

            Image(
                painter = painterResource(id = R.drawable.electronica_1),
                contentDescription = "Imagen de Electrónica",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "PlayStation 5",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.electronica_2),
                contentDescription = "Imagen de Electrónica",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Televisión 40'",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.electronica_3),
                contentDescription = "Imagen de Electrónica",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Auriculares inalámbricos",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.electronica_4),
                contentDescription = "Imagen de Electrónica",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Xbox One",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.electronica_5),
                contentDescription = "Imagen de Electrónica",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Router",
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



