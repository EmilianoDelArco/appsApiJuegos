package com.example.prueba3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prueba3.navigation.NavManager
import com.example.prueba3.ui.theme.Prueba3Theme
import com.example.prueba3.viewmodels.VideosJuegosViewModel

// Clase MainActivity que extiende de ComponentActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Se obtiene una instancia del ViewModel VideosJuegosViewModel
        val viewModel: VideosJuegosViewModel by viewModels()

        // Se establece el contenido de la actividad
        setContent {
            Prueba3Theme { // Se aplica el tema "nombre de tu app"
                // Contenedor Surface con el color de fondo del tema
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NavManager(viewModel = viewModel) // Se muestra el contenido gestionado por NavManager
                }
            }
        }
    }
}

