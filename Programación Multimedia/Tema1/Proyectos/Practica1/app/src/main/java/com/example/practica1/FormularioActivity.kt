package com.example.practica1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.practica1.ui.theme.Practica1Theme


class FormularioActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                Formulario()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Formulario() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var passwd by remember { mutableStateOf("") }
    var tlf by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var dir by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Column(
                Modifier.padding(20.dp)
            ) {
                Text(text = name)
                Row(
                    Modifier.padding(5.dp, 10.dp)
                ) {
                    Text("Nombre")
                    TextField(
                        value = name,
                        onValueChange = { text: String -> name = text }
                    )
                }
                Row() {
                    Text("Apellido")
                    TextField(
                        value = surname,
                        onValueChange = { text: String -> surname = text }
                    )
                }
                Row() {
                    Text("Contraseña")
                    TextField(
                        value = passwd,
                        onValueChange = { text: String -> passwd = text }
                    )
                }
                Row() {
                    Text("Teléfono")
                    TextField(
                        value = tlf,
                        onValueChange = { text: String -> tlf = text }
                    )
                }
                Row() {
                    Text("E-Mail")
                    TextField(
                        value = email,
                        onValueChange = { text: String -> email = text }
                    )
                }
                Row() {
                    Text("Dirección")
                    TextField(
                        value = dir,
                        onValueChange = { text: String -> dir = text }
                    )
                }
                Row() {
                    Text("Fecha de Nacimiento")
                    TextField(
                        value = birthDate,
                        onValueChange = { text: String -> birthDate = text }
                    )
                }
                BotonEnvio(
                    name,surname,passwd,tlf,email,dir,birthDate
                )
            }
        }
    }
}

@Composable
fun BotonEnvio(
    name : String,
    surname : String,
    passwd : String,
    tlf : String,
    email : String,
    dir : String,
    birthDate : String
){
    val contexto = LocalContext.current
    val intentExplicito = Intent(contexto, PerfilActivity::class.java).apply {
        putExtra("name", name)
        putExtra("surname", surname)
        putExtra("passwd", passwd)
        putExtra("tlf", tlf)
        putExtra("email", email)
        putExtra("dir", dir)
        putExtra("birthDate", birthDate)

    }
    Button(onClick = { contexto.startActivity(intentExplicito) }) {
        Text("Enviar")
    }
}