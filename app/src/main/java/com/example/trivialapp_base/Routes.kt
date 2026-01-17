package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object Game:Routes("GameScreen")
    object Result:Routes("ResultScreen")
    object Menu:Routes("MenuScreen")
}