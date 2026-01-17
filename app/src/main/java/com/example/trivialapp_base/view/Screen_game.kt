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
        fontSize = 20.sp
    )

    Text(
        "Hola",
        color = Color.Black,
        fontSize = 50.sp
    )
}