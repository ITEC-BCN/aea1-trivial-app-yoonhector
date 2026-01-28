package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp_base.ui.theme.LightSHINee
import com.example.trivialapp_base.ui.theme.SHINee
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun ResultScreen(navController: NavController, viewModel: GameViewModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(SHINee)
    ) {

        Text("RESULTS:")
        Text("${viewModel.puntuacion} points")
        Text("${viewModel.respuestasCorrectas}/10 correct answers",
        modifier = Modifier.padding(20.dp))

        Button(onClick = {
            navController.navigate("MenuScreen")},
            colors = ButtonDefaults.buttonColors(
                containerColor = LightSHINee,
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(40.dp)
        )
        {
            Text("Go to home")
        }
    }
}
