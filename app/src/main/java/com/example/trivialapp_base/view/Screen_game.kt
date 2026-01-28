package com.example.trivialapp_base.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp_base.ui.theme.*
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {


    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(SHINee)
    ) {

        LinearProgressIndicator(
            progress = viewModel.tiempoRestante,
            modifier = Modifier
                .padding(40.dp)
                .width(300.dp),
            color = DarkSHINee
        )

        Text(
            viewModel.preguntaActual!!.pregunta,
            fontWeight = FontWeight(525),
            modifier = Modifier.padding(20.dp)
        )
        Row(modifier = Modifier.height(150.dp))
        {
            Column (modifier = Modifier.padding(20.dp)){
                Button(
                    onClick = {
                        viewModel.progressBar += 0.1f
                        viewModel.responderPregunta(viewModel.respuestasMezcladas[0])
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightSHINee,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                {
                    Text(viewModel.respuestasMezcladas[0])
                }
                Button(
                    onClick = {
                        viewModel.progressBar += 0.1f
                        viewModel.responderPregunta(viewModel.respuestasMezcladas[1])
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightSHINee,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                {
                    Text(viewModel.respuestasMezcladas[1])

                }
            }
            Column (modifier = Modifier.padding(20.dp)){
                Button(
                    onClick = {
                        viewModel.progressBar += 0.1f
                        viewModel.responderPregunta(viewModel.respuestasMezcladas[2])
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightSHINee,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                {
                    Text(viewModel.respuestasMezcladas[2])
                }
                Button(
                    onClick = {
                        viewModel.progressBar += 0.1f
                        viewModel.responderPregunta(viewModel.respuestasMezcladas[3])
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightSHINee,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                {
                    Text(viewModel.respuestasMezcladas[3])
                }
            }
        }
            LinearProgressIndicator(
                progress = viewModel.progressBar,
                modifier = Modifier
                    .padding(40.dp)
                    .width(300.dp),
                color = DarkSHINee
            )
        if (viewModel.juegoTerminado) {
            navController.navigate("ResultScreen")
        }
    }
}
