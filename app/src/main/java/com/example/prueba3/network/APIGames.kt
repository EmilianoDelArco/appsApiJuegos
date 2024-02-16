package com.example.prueba3.network

import com.example.prueba3.models.VideoJuegoModel
import com.example.prueba3.utils.Constantes
import retrofit2.Response

import retrofit2.http.GET

// Interfaz que define las operaciones para interactuar con la API de juegos
interface APIGames {
    // Método para obtener la lista de juegos desde la API
    @GET("games${Constantes.API_KEY}")
    suspend fun obtenerJuegos(): Response<VideoJuegoModel>
}

