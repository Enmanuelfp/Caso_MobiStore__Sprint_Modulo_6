package com.bootcamp.caso_mobistore__sprint_modulo_6.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.bootcamp.caso_mobistore__sprint_modulo_6.ui.theme.Color2
import com.bootcamp.caso_mobistore__sprint_modulo_6.ui.theme.Color3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    titulo: String,
    mostrarBotton: Boolean = false,
    onClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = titulo, color = Color.White, fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color2
        ),
        navigationIcon = {
            if (mostrarBotton) {
                IconButton(onClick = { onClick() }) {
                    Icon(
                        Icons.AutoMirrored.Default.ArrowBack,
                        "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}