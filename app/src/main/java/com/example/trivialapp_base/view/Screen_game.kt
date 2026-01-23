package com.example.trivialapp_base.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        LinearProgressIndicator(progress = viewModel.tiempoRestante,
            Modifier.width(400.dp))

        Text(viewModel.preguntaActual!!.pregunta)
        Row {
            Button(
                onClick = {
                    viewModel.progressBar += 0.1f
                    viewModel.responderPregunta(viewModel.respuestasMezcladas[0])
                }
            )
            {
                Text(viewModel.respuestasMezcladas[0])
            }
            Button(
                onClick = {
                    viewModel.progressBar += 0.1f
                    viewModel.responderPregunta(viewModel.respuestasMezcladas[1])
                }
            )
            {
                Text(viewModel.respuestasMezcladas[1])

            }
        }
        Row {
            Button(
                onClick = {viewModel.progressBar += 0.1f
                    viewModel.responderPregunta(viewModel.respuestasMezcladas[2])}
            )
            {
                Text(viewModel.respuestasMezcladas[2])
            }
            Button(
                onClick = {viewModel.progressBar += 0.1f
                    viewModel.responderPregunta(viewModel.respuestasMezcladas[3])}
            )
            {
                Text(viewModel.respuestasMezcladas[3])
            }

            if (viewModel.juegoTerminado) {
                navController.navigate("ResultScreen")
            }
        }
        LinearProgressIndicator(progress = viewModel.progressBar,
            Modifier.width(400.dp))
    }

}
