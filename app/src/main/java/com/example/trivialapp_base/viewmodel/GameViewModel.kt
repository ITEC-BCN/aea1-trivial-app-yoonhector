package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.material3.Switch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas
import com.example.trivialapp_base.view.GameScreen
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = ProveedorPreguntas.obtenerPreguntas()
    private var numerosAleatoris = intArrayOf()
    private var round = 0

    var indicePreguntaActual by mutableIntStateOf(0)
        private set
    private var indicesUsados = intArrayOf()
    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(100f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var respuestasCorrectas by mutableIntStateOf(0)
        private set

    var progressBar by mutableStateOf(0.0f)

    var dificultadSeleccionada by mutableStateOf("")
        private set

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // Sense .value!
    }
    fun iniciarJuego() {
        round = 0
        indicesUsados = intArrayOf()
        puntuacion = 0
        juegoTerminado = false
        respuestasCorrectas = 0
        progressBar = 0.0f

        when (dificultadSeleccionada) {
            "Easy" -> numerosAleatoris = intArrayOf(0, 9)
            "Medium" -> numerosAleatoris = intArrayOf(10, 19)
            "Hard" -> numerosAleatoris = intArrayOf(20, 29)
        }
        cargarSiguientePregunta()
    }

    private fun cargarSiguientePregunta() {
        round++

        do {
            indicePreguntaActual = (numerosAleatoris[0]..numerosAleatoris[1]).random()
        } while (indicePreguntaActual in indicesUsados)

        indicesUsados += indicePreguntaActual

        iniciarTimer()

        preguntaActual = preguntasPartida[indicePreguntaActual]

        respuestasMezcladas = listOf(preguntaActual!!.respuesta1, preguntaActual!!.respuesta2, preguntaActual!!.respuesta3, preguntaActual!!.respuesta4).shuffled()
    }

    fun responderPregunta(respuestaUsuario: String) {
        if (respuestaUsuario == preguntaActual?.respuestaCorrecta) {
            when (dificultadSeleccionada) {
                "Easy" -> puntuacion += (tiempoRestante + 1 * 1.5).toInt()
                "Medium" -> puntuacion += (tiempoRestante + 1 * 2).toInt()
                "Hard" -> puntuacion += (tiempoRestante + 1 * 3).toInt()
            }

            respuestasCorrectas++
        }

        if (indicesUsados.size == 10) {
            juegoTerminado = true;
            onCleared()
        } else {
            avanzarRonda()
        }
    }

    private fun avanzarRonda() {
        if (indicesUsados.size < 10) {
            cargarSiguientePregunta()
        }
    }

    private fun iniciarTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA
            }

            override fun onFinish() {
                tiempoRestante = 0f
                progressBar += 0.1f
                avanzarRonda()
            }
        }.start()
    }
    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    fun getPuntuacion(): String {
        return puntuacion.toString()
    }
}
