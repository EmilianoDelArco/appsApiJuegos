package com.example.prueba3.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.prueba3.components.CardJuego
import com.example.prueba3.components.MainTopBar
import com.example.prueba3.utils.Constantes
import com.example.prueba3.viewmodels.VideosJuegosViewModel

// Función composable que muestra la vista de inicio
@Composable
fun InicioView(navController: NavController, viewModel: VideosJuegosViewModel) {
    Scaffold(
        topBar = {
            MainTopBar(titulo = "API JUEGOS") // Barra superior de la aplicación
        }
    ) {
        ContenidoInicioView(navController = navController, viewModel = viewModel, pad = it) // Contenido de la vista de inicio
    }
}

// Función composable que muestra el contenido de la vista de inicio
@Composable
fun ContenidoInicioView(navController: NavController, viewModel: VideosJuegosViewModel, pad: PaddingValues) {
    val juegos by viewModel.juegos.collectAsState() // Se obtiene la lista de juegos del ViewModel

    // Columna con scroll lazy para mostrar la lista de juegos
    LazyColumn(
        modifier = Modifier
            .padding(pad)
            .background(Color(Constantes.COLOR_ROJO))
    ) {
        items(juegos) { juego ->
            CardJuego(juego = juego) {} // Se muestra un CardJuego para cada juego en la lista
            println(juego)
            Text(
                text = juego.nombre, // Se muestra el nombre del juego
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
        }
    }
}

