package com.example.trivialapp_base.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    Text(
        "Round 1/10",
        color = Color.Black,
        fontSize = 30.sp
    )

    Text(
        viewModel.preguntaActual,
        color = Color.Black,
        fontSize = 30.sp
    )
}