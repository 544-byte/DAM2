package org.example.project.views

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.style.FontSizeScope
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.models.ParcelaM
import org.example.project.states.ParcelaS
import org.example.project.viewModels.ParcelaVM


@OptIn(ExperimentalFlexBoxApi::class)
@Composable
fun ParcelaV(viewModel : ParcelaVM){
    val parcelas = viewModel.uiState.collectAsState().value.parcelas
    Scaffold(Modifier.fillMaxSize()) {
        Box(Modifier.fillMaxSize()){
            Column(
                Modifier.align(Alignment.Center).
                verticalScroll(rememberScrollState()).
                horizontalScroll(rememberScrollState())
            ) {
                var i = 0
                var numCol = 3
                while (i < parcelas.size){
                    Row(
                        Modifier.align(Alignment.CenterHorizontally)

                    ) {
                        Parcela(
                            parcelas[i],
                            onCambiarEstado = {
                                viewModel.cambiarEstadoDeRiego(it)
                            }
                        )
                        i++
                        while (i < parcelas.size && i%numCol!=0){
                            Parcela(
                                parcelas[i],
                                onCambiarEstado = {
                                    viewModel.cambiarEstadoDeRiego(it)
                                }
                          )
                            i++
                        }
                    }
                }
                Card(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Column {
                        Text(
                            text= "Parcelas activadas para riego",
                            Modifier.padding(20.dp).align(Alignment.CenterHorizontally),
                            fontSize = 20.sp
                        )
                        FlexBox(
                            Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            for (p in parcelas) {
                                if (p.isBeingWatered) {
                                    Text(p.name,
                                        Modifier.padding(5.dp,2.dp)
                                    )
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Parcela(parcela : ParcelaM, onCambiarEstado: (ParcelaM) -> Unit){

    Card(
        modifier = Modifier.padding(10.dp)
    ) {
        Column(

        ){
            Text(
                parcela.name,
                Modifier.padding(10.dp,5.dp)
                    .align(Alignment.Start),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Row(
                Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text="${parcela.surface} hectáreas",
                    Modifier.padding(7.5.dp,5.dp),
                    fontSize = 14.sp
                )
                Text(
                    text="Cultivo actual: ${parcela.cropType}",
                    Modifier.padding(10.dp,5.dp),
                    fontSize = 14.sp
                )
            }
            Row (
                Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "${if(parcela.needsWater) {"Necesita riego"} else {"No necesita riego"} }",
                    Modifier.padding(10.dp,5.dp),
                    fontSize = 14.sp
                )
                Text(
                    text="Necesita ${parcela.waterNeeded()} L.",
                    Modifier.padding(10.dp,5.dp),
                    fontSize = 14.sp
                )

            }
            Button(
                onClick = { onCambiarEstado(parcela) },
                Modifier.align(Alignment.CenterHorizontally).padding(5.dp),
                contentPadding = PaddingValues(12.dp,4.dp)
            ) {
                Text(if(parcela.isBeingWatered) {"Regando"} else {"Regar"},
                fontSize = 14.sp
                )
            }
        }
    }
}