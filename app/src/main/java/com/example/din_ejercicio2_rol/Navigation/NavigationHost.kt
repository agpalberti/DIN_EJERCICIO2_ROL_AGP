package com.example.din_ejercicio2_rol.Navigation

import ScreenAbrirPuerta
import ScreenCamino
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.din_ejercicio2_rol.StartScreen
import ScreenCaminoStart
import ScreenCasa
import ScreenCruzarRio
import ScreenEncontrarLlave
import ScreenEncontrarLlaveValla
import ScreenEntrarSigilo
import ScreenGritar
import ScreenRio
import ScreenSeguirOrilla
import ScreenSeguirSol
import ScreenVictoria
import ScreenDireccionContraria

@Composable
fun NavigationHost (navController: NavHostController,startDestination: String){
    NavHost(
        navController = navController,
        startDestination = startDestination )
    {
        composable(Destinations.generico.ruta){
           //screen(navController)
        }

        composable(Destinations.ScreenCaminoStart.ruta){
            ScreenCaminoStart(navController)
        }

        composable(Destinations.StartScreen.ruta){
            StartScreen(navController)
        }

        composable(Destinations.ScreenCasa.ruta){
            ScreenCasa(navController)
        }
        
        composable(Destinations.ScreenEntrarSigilo.ruta){
            ScreenEntrarSigilo(navController = navController)
        }

        composable(Destinations.ScreenGritar.ruta){
            ScreenGritar(navController = navController)
        }
        
        composable(Destinations.ScreenEncontrarLlaveValla.ruta){
            ScreenEncontrarLlaveValla(navController = navController)
        }
        

        composable(Destinations.ScreenCamino.ruta){
            ScreenCamino(navController = navController)
        }

        composable(Destinations.ScreenSeguirSol.ruta){
            ScreenSeguirSol(navController = navController)
        }

        composable(Destinations.ScreenAbrirPuerta.ruta){
            ScreenAbrirPuerta(navController = navController)
        }

        composable(Destinations.ScreenDireccionContraria.ruta){
            ScreenDireccionContraria(navController)
        }

        composable(Destinations.ScreenRio.ruta){
            ScreenRio(navController = navController)
        }

        composable(Destinations.ScreenCruzarRio.ruta){
            ScreenCruzarRio(navController)
        }
        
        composable(Destinations.ScreenSeguirOrilla.ruta){
            ScreenSeguirOrilla(navController = navController)
        }
        
        composable(Destinations.ScreenEncontrarLlave.ruta){
            ScreenEncontrarLlave(navController = navController)
        }

        composable(Destinations.ScreenVictoria.ruta){
            ScreenVictoria(navController = navController)
        }
    }
}









