package com.example.practicatema2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RadioButton
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicatema2.ui.theme.PracticaTema2Theme
import java.time.LocalDate

class PerfilActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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
                        Column(
                            Modifier.fillMaxWidth(),
                            Arrangement.spacedBy(25.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Column(
                                Modifier.fillMaxWidth(),
                                Arrangement.spacedBy(15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Perfil de usuario",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .background(Color.Green)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center
                                )   // Titulo
                                Image(
                                    painter = painterResource(R.drawable.ic_launcher),
                                    contentDescription = "Logo",
                                    modifier = Modifier
                                        .size(180.dp)
                                )   // Imágen
                                Row{
                                    Text(
                                        "[Nombre de usuario]",
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(45.dp)
                                            .background(Color.Green)
                                            .wrapContentHeight(Alignment.CenterVertically),
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(Modifier.weight(0.5f))
                                    Text(
                                        "[rol de usuario]",
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(45.dp)
                                            .background(Color.Green)
                                            .wrapContentHeight(Alignment.CenterVertically),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                            Row{
                                var mostrar by remember {mutableStateOf(false)}
                                var contraseña = "[Contraseña]"
                                Text(
                                    if (mostrar) contraseña else "·".repeat(contraseña.length),
                                    modifier = Modifier
                                        .clickable(true, onClick = { mostrar = !mostrar })
                                        .weight(1f)
                                        .height(45.dp)
                                        .background(Color.Cyan)
                                        .wrapContentHeight(Alignment.CenterVertically),
                                    textAlign = TextAlign.Center,

                                    )
                            }
                            Column(
                                Modifier.fillMaxWidth(),
                                Arrangement.spacedBy(25.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row{
                                    Text(
                                        "Rol actual",
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(45.dp)
                                            .background(Color.Green)
                                            .wrapContentHeight(Alignment.CenterVertically),
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(Modifier.weight(0.5f))
                                    Text(
                                        "Ajustes de correo",
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(45.dp)
                                            .background(Color.Green)
                                            .wrapContentHeight(Alignment.CenterVertically),
                                        textAlign = TextAlign.Center
                                    )
                                }
                                Row(
                                    Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    var rol by remember {mutableStateOf("")}
                                    Column(
                                        Modifier.weight(1f)
                                    ){
                                        Row(
                                            modifier = Modifier.offset(x = (-8).dp)
                                        ){
                                            RadioButton(
                                                selected = rol == "admin",
                                                onClick = { rol = "admin" },
                                            )
                                            Text("Administración", fontSize = 14.sp)
                                        }
                                        Row(
                                            modifier = Modifier.offset(x = (-8).dp)
                                        ){
                                            RadioButton(
                                                selected = rol == "cliente",
                                                onClick = { rol = "cliente" }
                                            )
                                            Text("Cliente", fontSize = 14.sp)
                                        }
                                    }
                                    Spacer(Modifier.weight(0.5f))
                                    Row(Modifier.weight(1f)) {
                                        var recibirCorreo by remember { mutableStateOf(false) }
                                        Checkbox(
                                            checked = recibirCorreo,
                                            onCheckedChange = { recibirCorreo = !recibirCorreo }
                                        )
                                        Text("Recibir correo", fontSize = 16.sp)
                                    }
                                }
                            }

                        }
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