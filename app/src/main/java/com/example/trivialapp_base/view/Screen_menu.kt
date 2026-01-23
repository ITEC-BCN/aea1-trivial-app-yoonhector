package com.example.trivialapp_base.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel
import androidx.compose.ui.window.Dialog

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){

        Text("El mega suculento y para nada complicado juego de trivia")
        Text("Por Yoon y Hector")

        Image(
            painter = painterResource(id = com.example.trivialapp_base.R.drawable.payaso),
            contentDescription = "Example",
            modifier = Modifier.clip(RoundedCornerShape(100f))
        )

        Row {
            Button(
                onClick = {
                    viewModel.setDificultad("Easy")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            )
            {
                Text("Easy")
            }
            Button(
                onClick = {
                    viewModel.setDificultad("Medium")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            )
            {
                Text("Medium")
            }
            Button(
                onClick = {
                    viewModel.setDificultad("Hard")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black
                )
            )
            {
                Text("Hard")
            }
        }
        Button(onClick = {
            if (viewModel.dificultadSeleccionada.isEmpty()) {

            } else {
                navController.navigate("GameScreen")
                viewModel.iniciarJuego()
            }
        }
        )
        {
            Text("Start")
        }
    }
}
@Composable
fun TasBobo(){
    Dialog(onDismissRequest = {}) {
        Column(
            Modifier.background(Color.White)
                .fillMaxWidth()
        ) {
            Text("You must select a difficulty")
        }
    }
}