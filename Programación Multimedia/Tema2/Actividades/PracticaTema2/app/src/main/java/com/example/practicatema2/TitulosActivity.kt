package com.example.practicatema2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.sp
import com.example.practicatema2.ui.theme.PracticaTema2Theme
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class TitulosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaTema2Theme {
                val context = LocalContext.current
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
                        dibujarTitulos()
                        Spacer(Modifier.weight(1f))
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

@Composable
fun dibujarTitulos(){
    LazyColumn {
        items(cargarTitulos()) {
                linea ->
            val campos = linea.split(',')
            tarea(campos[0],campos[1],campos[2],campos[3],campos[4],campos[5])
    }
}

}

fun cargarTitulos(): List<String> {
    try {
        return File("titulos.csv").readLines()
    } catch (e: Exception) {
        return emptyList()
    }
}

@Composable
fun tarea(
    titulo: String,
    fecha: String,
    desc: String,
    puntuacion: String,
    plataforma: String,
    nJugadores: String
){
    Column {
        Text("Título: $titulo")
        Text("Fecha: $fecha")
        Text("Descripción: $desc")
        Text("Puntuación: $puntuacion")
        Text("Plataforma: $plataforma")
        Text("Jugadores: $nJugadores")
    }
}