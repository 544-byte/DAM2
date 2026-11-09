package com.example.practicatema2

import android.content.Intent
import android.os.Build
import android.os.Bundle
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.getSelectedDate
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

class TareaActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaTema2Theme {
                val titulo = intent.getStringExtra("titulo")
                val desc = intent.getStringExtra("descripcion")
                val priority = intent.getStringExtra("prioridad")
                val limite = intent.getStringExtra("limite")
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Gray)) {}
                    Spacer(Modifier.padding(15.dp))
                    Column(Modifier
                        .fillMaxSize()
                        .padding(30.dp, 0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Column(
                            Modifier.fillMaxWidth(),
                            Arrangement.spacedBy(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = titulo ?: "no hay titulo pe",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(Color.Green)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Center
                            )   // Titulo
                            Text(
                                text = desc ?: "no hay descripción pe",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .background(Color.Green)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Justify,


                            )   // Descripción
                            Row{
                                Text(
                                    "Prioridad",
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(25.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.weight(0.6f))
                                Text(
                                    "Fecha límite",
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(25.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Row{
                                Text(
                                    priority ?: "no hay prioridad pe",
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(45.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.weight(0.4f))
                                Text(
                                    limite ?: "no hay limite pe",
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(45.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }

                        }
                        Spacer(Modifier.padding(15.dp))
                        Spacer(Modifier.weight(1f))
                        val context = LocalContext.current
                        Button(onClick = {
                            val intent = Intent(context, NuevaTareaActivity::class.java).apply {
                                putExtra("titulo",titulo)
                                putExtra("descripcion", desc)
                                putExtra("prioridad",priority)
                                putExtra("limite",limite)
                            }
                            context.startActivity(intent)
                        }) {
                            Text(
                                "Editar tarea",
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