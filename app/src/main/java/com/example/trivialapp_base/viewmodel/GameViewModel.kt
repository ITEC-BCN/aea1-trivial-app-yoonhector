package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = emptyList()
    private var numerosAleatoris = intArrayOf()

    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
        private set

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(100f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var dificultadSeleccionada by mutableStateOf("")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // Sense .value!
    }
    fun iniciarJuego() {
        when (dificultadSeleccionada) {
            "Easy" -> numerosAleatoris = intArrayOf(0, 9)
            "Medium" -> numerosAleatoris = intArrayOf(10, 19)
            "Hard" -> numerosAleatoris = intArrayOf(20, 29)
        }
    }

    private fun cargarSiguientePregunta() {
    }

    fun responderPregunta(respuestaUsuario: String) {
        puntuacion += tiempoRestante.toInt()
    }

    private fun avanzarRonda() {
    }

    private fun iniciarTimer() {
        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 1000L) {
            override fun onTick(millisUntilFinished: Long) {

                val progreso = (millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA.toFloat()) * 100f
                tiempoRestante = progreso
            }

            override fun onFinish() {s
                tiempoRestante = 0f
                avanzarRonda()
            }
        }.start()
    }

    override fun onCleared() {
    }
}
