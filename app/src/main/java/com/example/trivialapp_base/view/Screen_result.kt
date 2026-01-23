package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("a")
        Text("a")
        Text("a")
        Text("a")
        Text("a")
        Text("a")
        Text("a")

        Text("RESULTS:")
        Text("${viewModel.puntuacion} points")
        Text("${viewModel.respuestasCorrectas}/10 correct answers")
        Button(onClick = {
            navController.navigate("MenuScreen")
        }
        )
        {
            Text("Go to home")
        }
    }
}