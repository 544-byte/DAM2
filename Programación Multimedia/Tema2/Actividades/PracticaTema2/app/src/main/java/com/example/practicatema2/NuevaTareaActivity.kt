package com.example.practicatema2

import android.R
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.getSelectedDate
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicatema2.ui.theme.PracticaTema2Theme
import java.time.LocalDate

class NuevaTareaActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaTema2Theme {
                val titulo = intent.getStringExtra("titulo")
                val descripcion = intent.getStringExtra("descripcion")
                val prioridad = intent.getStringExtra("priority")
                val limite = intent.getStringExtra("limite")
                var title by remember { mutableStateOf(titulo ?: "") }
                var desc by remember { mutableStateOf(descripcion ?: "") }
                var priority by remember { mutableStateOf(prioridad?.toFloatOrNull() ?:  5f) }
                val state = rememberDatePickerState(limite?.let { LocalDate.parse(it) } ?: LocalDate.now())


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Gray)) {
                    }
                    Spacer(Modifier.padding(15.dp))
                    Column(Modifier
                        .fillMaxSize()
                        .padding(30.dp, 0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            "Añadir nueva tarea",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(Color.Green)
                                .wrapContentHeight(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )   // Titulo
                        Spacer(Modifier.padding(7.dp))
                        Column(
                            Modifier.fillMaxWidth(),
                            Arrangement.spacedBy(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {     // formulario
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) { // Título
                                Text("Título",
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(120.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                TextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = title,
                                    label = { Text("Ingresa el título") },
                                    onValueChange = {title = it},
                                    colors = TextFieldDefaults.colors(
                                        focusedTextColor = Color.Black,
                                        unfocusedTextColor = Color.Black,
                                        focusedLabelColor = Color.Black,
                                        unfocusedLabelColor = Color.Black,
                                        focusedContainerColor = Color.Cyan,
                                        unfocusedContainerColor = Color.Cyan
                                    )
                                )
                            }
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) { // Descripción
                                Text ("Descripción",
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(120.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                TextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = desc,
                                    label = { Text("Ingresa la descripción") },
                                    onValueChange = {desc = it},
                                    colors = TextFieldDefaults.colors(
                                        focusedTextColor = Color.Black,
                                        unfocusedTextColor = Color.Black,
                                        focusedLabelColor = Color.Black,
                                        unfocusedLabelColor = Color.Black,
                                        focusedContainerColor = Color.Cyan,
                                        unfocusedContainerColor = Color.Cyan
                                    )
                                )
                            }
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) { // Slider
                                Text("Prioridad: ${priority.toInt()}",
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(120.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Slider(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = priority,
                                    onValueChange = { priority = it },
                                    valueRange = 0f..10f,
                                    steps = 9,
                                    colors = SliderDefaults.colors(
                                        thumbColor = Color.Black,
                                        activeTickColor = Color.Black,
                                        activeTrackColor = Color.Black,
                                        inactiveTickColor = Color.Black,
                                        inactiveTrackColor = Color.Black
                                    )
                                )
                            }
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(5.dp)
                            ) { // Fecha limite
                                Text ("Fecha límite",
                                    modifier = Modifier
                                        .height(25.dp)
                                        .width(120.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                var mostrarCalendario by remember { mutableStateOf(false) }
                                Text("Ingresa fecha límite (${state.getSelectedDate().toString()})",
                                    Modifier.clickable(onClick = {mostrarCalendario = true})
                                        .fillMaxWidth().height(50.dp).background(Color.Cyan)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,

                                )
                                if (mostrarCalendario){
                                    DatePickerDialog(
                                        onDismissRequest = { mostrarCalendario = false },
                                        confirmButton = {
                                            Button( onClick = {mostrarCalendario = false}) {
                                                Text("Aceptar")
                                            }
                                        }
                                    ) {
                                        DatePicker(state = state)
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.padding(15.dp))
                        Spacer(Modifier.weight(1f))
                        val context = LocalContext.current
                        Button(onClick = {
                            val intent = Intent(context, TareaActivity::class.java).apply {
                                putExtra("titulo",title)
                                putExtra("descripcion", desc)
                                putExtra("prioridad",priority.toInt().toString())
                                putExtra("limite",state.getSelectedDate().toString())
                            }
                            context.startActivity(intent)
                        }) {
                            Text(
                                "Guardar tarea",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(Modifier.padding(5.dp))
                        Button(onClick = {
                            val intent = Intent(context, LlegadaActivity::class.java)
                            context.startActivity(intent)
                        }) {
                            Text(
                                "Volver al menú principal",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}