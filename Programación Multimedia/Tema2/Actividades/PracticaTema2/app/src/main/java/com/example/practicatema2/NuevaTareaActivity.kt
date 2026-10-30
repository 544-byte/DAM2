package com.example.practicatema2

import android.os.Build
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicatema2.ui.theme.PracticaTema2Theme
import java.time.LocalDate

class NuevaTareaActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaTema2Theme {
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
                            "${LocalDate.now().dayOfMonth}, ${LocalDate.now().monthValue} de ${LocalDate.now().year}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(Color.Green)
                                .wrapContentHeight(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.padding(15.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            Arrangement.SpaceBetween,
                            Alignment.CenterVertically
                        ) {
                            Image(
                                painterResource(R.drawable.ic_launcher),
                                "",
                                Modifier.size(160.dp)
                            )
                            Column(){
                                Text("¡Bienvenido!",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(175.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.padding(5.dp))
                                Text("nombre de usuario",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(175.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.padding(5.dp))
                                Text("rol de usuario",
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(175.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(Modifier.padding(15.dp))
                        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
                            Text(
                                "Tareas Pendientes",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(Color.Green)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Center
                            )
                            Row() {
                                Text(
                                    "Tarea 1",
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.weight(0.25f))
                                Text(
                                    "Fecha límite",
                                    modifier = Modifier
                                        .weight(0.25f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Row() {
                                Text(
                                    "Tarea 2",
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.weight(0.25f))
                                Text(
                                    "Fecha límite",
                                    modifier = Modifier
                                        .weight(0.25f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Row() {
                                Text(
                                    "Tarea 3",
                                    modifier = Modifier
                                        .weight(0.5f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                                Spacer(Modifier.weight(0.25f))
                                Text(
                                    "Fecha límite",
                                    modifier = Modifier
                                        .weight(0.25f)
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )
                            }

                        }
                        
                        Spacer(Modifier.weight(1f))
                        Button(onClick = {}) {
                            Text(
                                "Añadir tareas",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .wrapContentHeight(Alignment.CenterVertically),
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(Modifier.padding(5.dp))
                        Row(
                            Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {}, Modifier.weight(1f)) {
                                Text(
                                    "Perfil",
                                    modifier = Modifier
                                        .height(50.dp)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                    ,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Spacer(Modifier.padding(20.dp,0.dp))
                            Button(onClick = {}, Modifier.weight(1f)) {
                                Text(
                                    "Ajustes",
                                    modifier = Modifier
                                        .height(50.dp)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                    ,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}