package com.example.practicatema2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicatema2.ui.theme.PracticaTema2Theme
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.name
import kotlin.io.path.readLines

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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ){
                        Box(
                            Modifier.weight(1f)
                        ) {
                            dibujarTitulos()
                        }
                        Button(
                            onClick = {
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
    val context = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        items(cargarTitulos(context)) {
                linea ->
            val campos = linea.split(',')
            tarea(campos[0],campos[1],campos[2],campos[3],campos[4],campos[5])

        }
    }
}

fun cargarTitulos(context: Context): List<String> {
    try {
        return context.resources.openRawResource(R.raw.titulos).bufferedReader().readLines()
    } catch (e: Exception) {
        throw e
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
    Column (
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(80.dp)
        ) {
            Text(
                titulo,
                modifier = Modifier
                    .weight(1f)
                    .defaultMinSize(0.dp, 45.dp)
                    .background(Color.Green)
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
            Text(
                fecha,
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .background(Color.Green)
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
        Text(
            desc.replace("\"",""),
            modifier = Modifier
                .background(Color.Green)
                .defaultMinSize(0.dp, 45.dp)
                .wrapContentHeight(Alignment.CenterVertically)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                puntuacion,
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .background(Color.Green)
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
            Text(
                plataforma,
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .background(Color.Green)
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
            Text(
                nJugadores,
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp)
                    .background(Color.Green)
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }

    }
}