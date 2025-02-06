package com.donealo.donealoapp

import PantallaSQLite
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.donealo.donealoapp.ui.theme.DonealoAPPTheme
import android.view.OrientationEventListener
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


class MainActivity : ComponentActivity() {

    private val TAG = "MainActivityCicloVida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: La aplicación ha sido creada")
        setContent {
            DonealoAPPTheme {
                MainScreen()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: La actividad ha comenzado")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La actividad está lista.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: La actividad está a punto de ser detenida.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: La actividad ya no es visible para el usuario.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: La actividad ha sido destruida.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: La actividad ha sido reiniciada después de haber sido detenida.")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(TAG, "Pantalla girada a Horizontal (Landscape)")
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(TAG, "Pantalla girada a Vertical (Portrait)")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        content = { innerPadding ->

            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("home") {
                    HomeScreen(navController)
                }
                composable("ropa") {
                    SeccionRopa(navController)
                }
                composable("muebles") {
                    SeccionMuebles(navController)
                }
                composable("libros") {
                    SeccionLibros(navController)
                }
                composable("juguetes") {
                    SeccionJuguetes(navController)
                }
                composable("electronica") {
                    SeccionElectronica(navController)
                }
                composable("Donar") {
                    PantallaSQLite(contexto = LocalContext.current, navController = navController)
                }

            }
        }
    )
}


@Composable
fun DonacionesScreen(viewModel: DonacionViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val donaciones by viewModel.donaciones.collectAsState()

    LazyColumn {
        items(donaciones) { donacion ->
            Text(text = "${donacion.nombre}: ${donacion.descripcion}")
        }
    }
}


@Composable
fun HomeScreen(navController: androidx.navigation.NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Bienvenido a Donealo!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Con Donealo podrás donar lo que ya no quieres",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        // Imagen central
        Image(
            painter = painterResource(id = R.drawable.donar_main),
            contentDescription = "Logo de Donealo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Button(
            onClick = { navController.navigate("ropa") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ropa")
        }
        Button(
            onClick = { navController.navigate("electronica") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Electrónica")
        }
        Button(
            onClick = { navController.navigate("juguetes") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Juguetes")
        }
        Button(
            onClick = { navController.navigate("muebles") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Muebles")
        }
        Button(
            onClick = { navController.navigate("libros") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Libros")
        }

        Button(
            onClick = { navController.navigate("Donar") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Donaciones")
        }

    }
}
