package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.models.Pelicula
import org.example.project.viewModels.BibliotecaVM

@OptIn(ExperimentalFlexBoxApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Buscador(viewModel : BibliotecaVM) {
    val biblioteca = viewModel.uiState.collectAsState().value
    var filtroNombre by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var filtroGenre by remember { mutableStateOf("") }

    val generos = listOf(
        "",
        "Acción",
        "Animación",
        "Ciencia Ficción",
        "Comedia",
        "Drama",
        "Fantasía",
        "Musical",
        "Romance"
    )


    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Gray)
                .align(Alignment.TopCenter)
                .padding(5.dp,10.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            TextField(
                value = filtroNombre ,
                onValueChange = { filtroNombre = it },
                placeholder = {
                    Text("Buscar")
                }
            )
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = filtroGenre,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.menuAnchor(),
                    label = { Text("Género") }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    generos.forEach { genero ->
                        DropdownMenuItem(
                            text = { Text(genero) },
                            onClick = {
                                filtroGenre = genero
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(40.dp))
        FlowRow(){
            DibujarPeliculas(biblioteca.peliculasFiltradas(filtroNombre,filtroGenre))
        }
    }
}

@Composable
fun DibujarPeliculas(biblioteca: List<Pelicula>) {
    for (pelicula in biblioteca) {
        Card(
            modifier = Modifier.size(175.dp, 220.dp).padding(9.dp, 6.dp)
        ) {
            Text(pelicula.title)
        }
    }
}