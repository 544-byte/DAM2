package com.example.practicatema2.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

var modoOscuro by mutableStateOf(false)
    private set

fun cambiarModoOscuro(valor: Boolean) {
    modoOscuro = valor
}

@Composable
fun ModoOscuroSwitch() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(
            checked = modoOscuro,
            onCheckedChange = ::cambiarModoOscuro
        )
    }
}
