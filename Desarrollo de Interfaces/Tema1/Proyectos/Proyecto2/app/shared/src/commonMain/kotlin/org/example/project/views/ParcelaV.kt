package org.example.project.views

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import org.example.project.models.ParcelaM
import org.example.project.states.ParcelaS
import org.example.project.viewModels.ParcelaVM


@Composable
fun ParcelaV(viewModel : ParcelaVM){
    val parcelas = viewModel.uiState.collectAsState().value.parcelas
    Scaffold(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize()){
            Column(
                Modifier.align(Alignment.Center)
            ) {
                var i = 0
                var numCol = 4
                while (i < parcelas.size){
                    Row(
                        Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Card(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text=parcelas[i].name,
                                Modifier.padding(10.dp)
                            )
                        }
                        i++
                        while (i < parcelas.size && i%numCol!=0){
                            Card(
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Text(
                                    parcelas[i].name,
                                    Modifier.padding(10.dp)
                                )

                            }
                            i++
                        }
                    }
                }
                Card(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text= "resumen",
                        Modifier.padding(20.dp)
                    )
                }
            }
        }
    }
}