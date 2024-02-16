package com.example.prueba3.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prueba3.viewmodels.VideosJuegosViewModel
import com.example.prueba3.views.InicioView

// Función composable que gestiona la navegación en la aplicación
@Composable
fun NavManager(viewModel: VideosJuegosViewModel) {
    val navController = rememberNavController() // Se obtiene el NavController para la navegación

    // Configuración de las rutas de navegación
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel) // Muestra la vista de inicio
        }
    }
}

