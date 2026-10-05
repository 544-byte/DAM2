package com.example.practica1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica1.ui.theme.Practica1Theme
import kotlin.jvm.java

class InicioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                val contexto = LocalContext.current

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Button(
                            onClick = {
                                val nombreIntent = Intent(contexto, FormularioActivity::class.java)
                                startActivity(nombreIntent)
                            }
                        ) {
                            Text("Formulario")
                        }
                        Button(
                            onClick = {
                                val nombreIntent = Intent(contexto, PerfilActivity::class.java)
                                startActivity(nombreIntent)
                            }
                        ) {
                            Text("Perfil")
                        }
                    }
                }
            }
        }
    }
}