import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.donealo.donealoapp.BaseDeDatosSQLite
import com.donealo.donealoapp.Donacion
import androidx.compose.ui.Alignment


@Composable

fun PantallaSQLite(contexto: Context, navController: androidx.navigation.NavController) {
    val dbHelper = BaseDeDatosSQLite(contexto)
    var nombre by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    val donaciones = remember { mutableStateOf(dbHelper.obtenerDonaciones()) }

    LaunchedEffect(Unit) {
        donaciones.value = dbHelper.obtenerDonaciones()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Campos para ingresar datos
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        TextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        // Botón para insertar datos
        Button(
            onClick = {
                if (nombre.isNotEmpty() && descripcion.isNotEmpty() && categoria.isNotEmpty()) {
                    // Insertar la donación, sin pasar el ID si es autoincrementable
                    dbHelper.insertarDonacion(Donacion(nombre = nombre, descripcion = descripcion, categoria = categoria))
                    donaciones.value = dbHelper.obtenerDonaciones()
                    nombre = ""
                    descripcion = ""
                    categoria = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Donación")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de donaciones
        LazyColumn {
            items(donaciones.value) { donacion ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Nombre: ${donacion.nombre}")
                            Text("Descripción: ${donacion.descripcion}")
                            Text("Categoría: ${donacion.categoria}")
                        }
                        Button(
                            onClick = {
                                donacion.id?.let { dbHelper.eliminarDonacion(it) } // Asegúrate de que el ID no sea nulo
                                donaciones.value = dbHelper.obtenerDonaciones()
                            }
                        ) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }

        // Botón para regresar al Home
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text("Volver a Home")
        }
    }
}

