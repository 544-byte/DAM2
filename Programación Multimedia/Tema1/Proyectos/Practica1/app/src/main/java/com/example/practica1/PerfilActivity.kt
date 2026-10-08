package com.example.practica1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica1.ui.theme.Practica1Theme

class PerfilActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                Perfil(intent)
            }
        }
    }
}


@Composable
fun Perfil (intent : Intent) {
    val name = intent.getStringExtra("name") ?: "[Nombre]"
    var surname = intent.getStringExtra("surname") ?: "[Apellidos]"
    var passwd = intent.getStringExtra("passwd") ?: "[Contraseña]"
    var tlf = intent.getStringExtra("tlf") ?: "[Teléfono]"
    var email = intent.getStringExtra("email") ?: "[email]"
    var dir = intent.getStringExtra("dir") ?: "[Dirección]"
    var birthDate = intent.getStringExtra("birthDate") ?: "[Fecha de nacimiento]"
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Column(
                Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Nombre: " + name,
                    modifier = Modifier.padding(5.dp,10.dp)
                )
                Text(
                    text = "Apellidos: " + surname,
                    modifier = Modifier.padding(5.dp,10.dp)
                )
                var passwdclean = ""
                for (i in passwd.toCharArray()){
                    passwdclean = passwdclean.plus("·")
                }
                Text(
                    text = "Contraseña: ${passwdclean}",
                    modifier = Modifier.padding(5.dp,10.dp)
                )
                Text(
                    text = "Teléfono: ${ tlf }",
                    modifier = Modifier.padding(5.dp,10.dp)
                        .clickable{
                            val intent = Intent(Intent.ACTION_DIAL).apply{
                                data = Uri.parse("tel:$tlf")
                            }
                            context.startActivity(intent)
                        }
                )
                Text(
                    text = "Correo electrónico: ${email}",
                    modifier = Modifier.padding(5.dp,10.dp)
                        .clickable{
                            val intent = Intent(Intent.ACTION_SENDTO).apply{
                                data = Uri.parse("mailto:$email")
                            }
                            context.startActivity(intent)
                        }
                )
                Text(
                    text = "Dirección: ${dir}",
                    modifier = Modifier.padding(5.dp,10.dp)
                        .clickable{
                            val intent = Intent(Intent.ACTION_VIEW).apply{
                                data = Uri.parse("geo:0,0?q=${Uri.encode(dir)}")
                            }
                            context.startActivity(intent)
                        }
                )
                Text(
                    text = "Fecha de nacimiento: ${birthDate}",
                    modifier = Modifier.padding(5.dp,10.dp)
                )
                Button(
                    onClick = {
                        (context as Activity).finish()
                    }
                ) { Text("Editar") }
                Button(
                    onClick = {
                        val intent = Intent(context, InicioActivity::class.java).apply {
                            flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK
                        }
                        context.startActivity(intent)
                    }
                ) { Text("Cerrar sesión") }
            }
        }
    }
}