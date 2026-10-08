package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.models.Pelicula
import org.example.project.viewModels.BibliotecaVM

@OptIn(ExperimentalFlexBoxApi::class)
@Composable
fun Buscador(viewModel : BibliotecaVM) {
    val peliculas = viewModel.uiState.collectAsState().value

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color.Red)
                .align(Alignment.TopCenter)
                .padding(5.dp,10.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Text("hpña")
        }
        Spacer(modifier = Modifier.padding(40.dp))
        FlowRow(){
            Pelicula()
            Pelicula()
            Pelicula()
            Pelicula()
            Pelicula()
        }
    }
}

@Composable
fun Pelicula() {
    Card(
        modifier = Modifier.size(175.dp,220.dp).padding(9.dp,6.dp)
    ) {

    }
}