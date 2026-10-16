package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.models.Receta
import org.example.project.viewModels.RecetarioVM

@OptIn(ExperimentalFlexBoxApi::class)
@Composable
fun RecetarioV(viewModel : RecetarioVM) {
    val (recetas, favoritas) = viewModel.uiState.collectAsState().value

    Box(Modifier.fillMaxSize()) {
        var recetasSeleccionadas by remember { mutableStateOf(recetas) }
        Row(
            Modifier.fillMaxWidth().align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (recetasSeleccionadas == recetas) recetasSeleccionadas = favoritas
                else recetasSeleccionadas = recetas
            }) {
                Text("Show/Hide Favourites")
            }
        }
        FlowRow(Modifier.align(Alignment.Center))
        {
            for (receta in recetasSeleccionadas){
                Column (
                    modifier =
                        Modifier.background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    if (receta.favorita) Color.Yellow else Color.Gray,
                                    if (receta.esRapida()) Color.Cyan else Color.Gray,
                                )
                            )
                        ).padding(20.dp)
                ) {
                    Text(receta.nombre)
                }
            }
        }
    }
}


