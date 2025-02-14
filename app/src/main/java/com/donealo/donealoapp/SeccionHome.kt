package com.donealo.donealoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.donealo.donealoapp.R

@Composable
fun SeccionHome(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "¡Bienvenido a Donealo!",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Con Donealo podrás donar lo que ya no quieres",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.donar_main),
            contentDescription = "Imagen representativa",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(listOf("Ropa", "Muebles", "Libros", "Juguetes", "Electrónica")) { item ->
                Button(
                    onClick = {
                        when (item) {
                            "Ropa" -> navController.navigate("ropa")
                            "Muebles" -> navController.navigate("muebles")
                            "Libros" -> navController.navigate("libros")
                            "Juguetes" -> navController.navigate("juguetes")
                            "Electrónica" -> navController.navigate("electronica")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = item)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
