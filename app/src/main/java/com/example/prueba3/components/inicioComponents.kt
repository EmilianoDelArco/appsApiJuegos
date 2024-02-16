package com.example.prueba3.components


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.prueba3.utils.Constantes
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.prueba3.models.VideoJuegosLista
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext


// Función composable que muestra la barra superior de la aplicación
@Composable
fun MainTopBar(titulo: String) {
    TopAppBar(
        title = {
            Text(
                text = titulo,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
        },
        backgroundColor = Color(Constantes.COLOR_NEGRO),
        contentColor = Color.White
    )
}

// Función composable que muestra un card de juego
@Composable
fun CardJuego(juego: VideoJuegosLista, onClick: () -> Unit) {
    val context = LocalContext.current // Se obtiene el contexto actual

    // Card con forma redondeada y sombra, con posibilidad de hacer clic
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .shadow(40.dp)
            .clickable {
                Toast.makeText(context, "Estamos trabajando", Toast.LENGTH_SHORT).show() // Se muestra un mensaje al hacer clic
                onClick() // Se ejecuta la acción onClick
            }
    ) {
        Column {
            InicioImagen(imagen = juego.imagen) // Se muestra la imagen del juego
        }
    }
}

// Función composable que muestra una imagen de inicio
@Composable
fun InicioImagen(imagen: String) {
    val painter = rememberImagePainter(data = imagen) // Se carga la imagen con rememberImagePainter

    // Imagen con contenido recortado y altura fija
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .height(250.dp)
    )
}

