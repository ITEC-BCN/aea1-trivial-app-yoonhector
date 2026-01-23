package com.example.trivialapp_base.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    var questionsLeft by rememberSaveable() { mutableStateOf(0.0f) }

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        Text("hola")
        Text("hola")
        Text("hola")
        Text("hola")
        Text("hola")
        Text("hola")

        Text("Texto que contiene pregunta")
        Row {
            Button(onClick = {questionsLeft += 0.1f })
            {
                Text("Pregunta1")
            }
            Button(onClick = {questionsLeft += 0.1f })
            {
                Text("Pregunta2")

            }
        }
        Row {
            Button(onClick = {questionsLeft += 0.1f })
            {
                Text("Pregunta3")
            }
            Button(onClick = {questionsLeft += 0.1f })
            {
                Text("Pregunta4")
            }
        }
        LinearProgressIndicator(progress = questionsLeft,
            Modifier.width(400.dp))
    }
}
