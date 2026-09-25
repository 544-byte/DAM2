package org.example.project.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


import org.example.project.viewModels.ArtVM

@Composable
fun ArtV(viewModel: ArtVM){
    val (artworks, currentArtwork) = viewModel.uiState.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.padding(20.dp)
        ){
            if (artworks != null) {
                for (artwork in artworks){
                    Card(
                        onClick = {
                            if (viewModel.isSelected(artwork)){
                                viewModel.deselectArt()
                            } else {
                                viewModel.selectArt(artwork)
                            }
                        },
                        modifier = Modifier.padding(5.dp)
                    ){
                        Text(
                            artwork.title,
                            modifier = Modifier.padding(10.dp)
                        )}
                }
            }
        }

        if (currentArtwork != null) {
            Card(
                modifier = Modifier.align(Alignment.Center)
                    .size(400.dp)

            ){
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    Button(
                        onClick = { viewModel.deselectArt() },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ){
                        Text("X")
                    }
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text =
                        """
                        Nombre: ${currentArtwork?.title}
                        Artista: ${currentArtwork.artist}
                        Año: ${currentArtwork.year}
                        Descripción: ${currentArtwork.desc}
                    """.trimIndent()

                    )
                }
            }
        }
    }
}
