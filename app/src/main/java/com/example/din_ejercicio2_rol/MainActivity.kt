package com.example.din_ejercicio2_rol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.din_ejercicio2_rol.Navigation.Destinations
import com.example.din_ejercicio2_rol.Navigation.NavigationHost
import com.example.din_ejercicio2_rol.ui.theme.DIN_EJERCICIO2_ROLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DIN_EJERCICIO2_ROLTheme {
                    Start()

            }
        }
    }
}

@Composable
fun Start() {
    NavigationHost(navController = rememberNavController(), startDestination = Destinations.StartScreen.ruta)
}

