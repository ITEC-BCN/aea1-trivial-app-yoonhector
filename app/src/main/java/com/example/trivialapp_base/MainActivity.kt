package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.MenuScreen
import com.example.trivialapp_base.view.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            TrivialAPP_BaseTheme {
                // Controlador de navegación
                val navigationController = rememberNavController()

                NavHost(
                    navController = navigationController as NavHostController,
                    startDestination = Routes.Menu.route
                ) {
                    composable(Routes.Menu.route) { MenuScreen(navigationController, easy) }
                    composable(Routes.Game.route) { GameScreen(navigationController) }
                    composable(Routes.Result.route) { ResultScreen(navigationController) }
                }

                // Instanciamos el ViewModel una vez



                // Definición de rutas y navegación



            }
        }
    }
}

