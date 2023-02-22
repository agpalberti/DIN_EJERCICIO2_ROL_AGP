package com.example.din_ejercicio2_rol.Navigation

sealed class Destinations (val ruta : String) {

    object generico: Destinations("Screen")

    object StartScreen: Destinations("StartScreen")

    object ScreenCaminoStart: Destinations("ScreenCaminoStart")
    object ScreenCamino: Destinations("ScreenCamino")

    object ScreenCasa: Destinations("ScreenCasa")
    object ScreenEntrarSigilo: Destinations("ScreenEntrarSigilo")
    object ScreenEncontrarLlaveValla: Destinations("ScreenEncontrarLlaveValla")
    object ScreenGritar: Destinations("ScreenGritar")

    object ScreenRio:Destinations("ScreenRio")
    object ScreenSeguirOrilla:Destinations("ScreenSeguirOrilla")
    object ScreenCruzarRio:Destinations("ScreenCruzarRio")
    object ScreenEncontrarLlave:Destinations("ScreenEncontrarLlave")

    object ScreenSeguirSol: Destinations("ScreenSeguirSol")
    object ScreenAbrirPuerta: Destinations("ScreenAbrirPuerta")
    object ScreenDireccionContraria: Destinations("ScreenDireccionContraria")

    object ScreenVictoria:Destinations("ScreenVictoria")
}