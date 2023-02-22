package com.example.din_ejercicio2_rol

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.din_ejercicio2_rol.Navigation.Destinations
import kotlinx.coroutines.delay
import systemBarColor


@Composable
fun StartScreen(navController: NavController) {

    systemBarColor(color = Color.Black)

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { visible = true }



    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(
            Modifier
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(
                        animationSpec = tween(durationMillis = 2500, easing = LinearOutSlowInEasing)
                    ),
                    exit = fadeOut(
                        animationSpec = tween(durationMillis = 2500, easing = LinearOutSlowInEasing)
                    )
                ) {
                    Text(
                        "Made by: \n\nAlejandro González Parra",
                        color = Color.White,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )

                    LaunchedEffect(true) {
                        delay(4500)
                        visible = false
                        delay(2500)
                        navController.navigate(Destinations.ScreenCaminoStart.ruta)
                    }

                }
            }
        }
    }


}


