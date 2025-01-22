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
fun SeccionRopa(navController: NavController) {
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
                text = "Sección de Ropa",
                style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Aquí puedes donar o encontrar ropa que otros ya no necesitan.",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            val imageSize = 200.dp

            Image(
                painter = painterResource(id = R.drawable.ropa_1),
                contentDescription = "Imagen de Ropa",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Camiseta de algodón",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ropa_2),
                contentDescription = "Imagen de Ropa",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Pantalón vaquero",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ropa_3),
                contentDescription = "Imagen de Ropa",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Cazadora",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ropa_4),
                contentDescription = "Imagen de Ropa",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Zapatos",
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ropa_5),
                contentDescription = "Imagen de Ropa",
                modifier = Modifier
                    .size(imageSize)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Gorro",
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


