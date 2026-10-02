package org.example.project.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalFlexBoxApi
import androidx.compose.foundation.layout.FlexBox
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.viewModels.AlumnoVM

@OptIn(ExperimentalFlexBoxApi::class)
@Composable
fun Formulario(viewModel: AlumnoVM){
    val (alumnos, newAlumno) = viewModel.uiState.collectAsState().value

    Box(
        Modifier.fillMaxSize()
    ){
        Column (
            Modifier.padding(30.dp,20.dp)
                .fillMaxSize()
        ){
            Row (Modifier.align(Alignment.CenterHorizontally)){
                Card(
                    Modifier.align(Alignment.CenterVertically)
                ){
                    Column (Modifier.padding(20.dp,10.dp)) {
                        OutlinedTextField(
                            label = { Text("Nombre") },
                            value = newAlumno.name,
                            onValueChange = { newName -> viewModel.onNameChange(newName) }
                        )
                        OutlinedTextField(
                            label = { Text("Nota Teórica") },
                            value = newAlumno.grades[0].toString(),
                            onValueChange = { newGrade: String ->
                                viewModel.onTGradeChange(
                                    newGrade.toDoubleOrNull() ?: 0.0
                                )
                            }
                        )
                        OutlinedTextField(

                            label = { Text("Nota Práctica") },
                            value = newAlumno.grades[1].toString(),
                            onValueChange = { newGrade: String ->
                                viewModel.onPGradeChange(
                                    newGrade.toDoubleOrNull() ?: 0.0
                                )
                            }
                        )
                        Button(
                            onClick = { viewModel.añadirAlumno() }
                        ) {
                            Text("Añadir alumno")
                        }
                    }
                }
            }

            FlexBox (
                Modifier.align(Alignment.CenterHorizontally)
            ){
                for (a in alumnos){
                    Card (
                        Modifier.padding(5.dp,10.dp),
                        colors = CardDefaults.cardColors(containerColor = if (a.didPass()) Color.Green else Color.Red)
                    ){
                        Column (
                            Modifier.padding(10.dp,4.dp)
                        ){
                            Text(a.name)
                            Text("Nota Teórica: ${a.grades[0]}")
                            Text("Nota Práctica: ${a.grades[1]}")
                        }

                    }
                }
            }
        }
    }
}