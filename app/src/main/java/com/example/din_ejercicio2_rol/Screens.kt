import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.din_ejercicio2_rol.Keys
import com.example.din_ejercicio2_rol.Navigation.Destinations
import com.example.din_ejercicio2_rol.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ScreenCaminoStart(navController: NavController) {
    Screen(
        navController = navController, idImagen = R.drawable.bosque,
        texto = "Te despiertas en un bosque, sin saber donde estás.¿Qué haces?",
        boton1 = Pair("Seguir el camino de tierra", Destinations.ScreenCasa.ruta),
        boton2 = Pair("Seguir el sonido de un río", Destinations.ScreenRio.ruta),
        boton3 = Pair("Ir en la dirección del amanecer", Destinations.ScreenSeguirSol.ruta)
    )
}


@Composable
fun ScreenCamino(navController: NavController) {

    Screen(
        navController = navController, idImagen = R.drawable.bosque,
        texto = "Te encuentras ante un camino de tierra. ¿Qué haces?",
        boton1 = Pair("Seguir el camino de tierra", Destinations.ScreenCasa.ruta),
        boton2 = Pair("Seguir el sonido de un río", Destinations.ScreenRio.ruta),
        boton3 = Pair("Ir en la dirección del amanecer", Destinations.ScreenSeguirSol.ruta)
    )

}

@Composable
fun ScreenCasa(navController: NavController) {

    Screen(
        navController = navController, idImagen = R.drawable.casa,
        texto = "Encuentras una casa en medio del bosque. No parece haber nadie. ¿Qué quieres hacer?",
        boton1 = Pair("Entrar en la casa sin hacer ruido", Destinations.ScreenEntrarSigilo.ruta),
        boton2 = Pair("Gritar para pedir ayuda", Destinations.ScreenGritar.ruta),
        boton3 = Pair("Volver al camino de tierra", Destinations.ScreenCamino.ruta)
    )

}

@Composable
fun ScreenEntrarSigilo(navController: NavController) {

    if (Keys.casaLlave) {
        Screen(
            navController = navController, idImagen = R.drawable.interior,
            texto = "Entras y no se escucha a nadie.",
            boton1 = Pair("Gritar para pedir ayuda", Destinations.ScreenGritar.ruta),
            boton2 = Pair("Mirar debajo de la mesa", Destinations.ScreenEncontrarLlaveValla.ruta),
            boton3 = Pair("Salir de la casa", Destinations.ScreenCasa.ruta),
            boton2Visible = !Keys.vallaLlave
        )
    } else {
        Screen(
            navController = navController, idImagen = R.drawable.casa,
            texto = "La puerta esta cerrada.",
            boton1 = Pair("Gritar para pedir ayuda", Destinations.ScreenGritar.ruta),
            boton2 = Pair("Volver al camino de tierra", Destinations.ScreenCamino.ruta),
            boton3 = Pair("", ""),
            boton3Visible = false
        )
    }

}

@Composable
fun ScreenEncontrarLlaveValla(navController: NavController) {
    Keys.vallaLlave = true
    Screen(
        navController = navController, idImagen = R.drawable.interior,
        texto = "Has encontrado una llave oxidada.",
        boton1 = Pair("Gritar para pedir ayuda", Destinations.ScreenGritar.ruta),
        boton2 = Pair("Salir de la casa", Destinations.ScreenCasa.ruta),
        boton3 = Pair("", ""),
        boton3Visible = false
    )
}


@Composable
fun ScreenGritar(navController: NavController) {
    ScreenDerrota(navController = navController,
        textoDeMuerte = "Un hombre con ropa harapienta aparece por atrás tuya y te golpea. " +
                "Te atrapa en el sótano de la casa y acabas ahí de por vida. " +
                "Has perdido.")
}

@Composable
fun ScreenSeguirSol(navController: NavController) {
    Screen(
        navController = navController, idImagen = R.drawable.fence,
        texto = "Encuentras una valla bloqueando el camino...",
        boton1 = Pair("Abrir la puerta", if (Keys.vallaLlave) Destinations.ScreenVictoria.ruta else Destinations.ScreenAbrirPuerta.ruta),
        boton2 = Pair("Ir en la dirección contraria", Destinations.ScreenDireccionContraria.ruta),
        boton3 = Pair("Volver al camino de tierra", Destinations.ScreenCamino.ruta)
    )
}

@Composable
fun ScreenDireccionContraria(navController: NavController) {
    ScreenDerrota(navController = navController,
        textoDeMuerte = "Vas en la dirección contraria y te pierdes. Has perdido.")
}

@Composable
fun ScreenAbrirPuerta(navController: NavController) {
    Screen(
        navController = navController, idImagen = R.drawable.fence,
        texto = "La puerta de la valla está cerrada.",
        boton1 = Pair("Ir en la dirección contraria", Destinations.ScreenDireccionContraria.ruta),
        boton2 = Pair("Volver al camino de tierra", Destinations.ScreenCamino.ruta),
        boton3 = Pair("", ""), boton3Visible = false
    )
}


@Composable
fun ScreenRio(navController: NavController) {

    Screen(
        navController = navController, idImagen = R.drawable.rio,
        texto = "Encuentras un río hondo y con mucho caudal. " +
                "Al otro lado del río, a lo lejos, parece haber gente...",
        boton1 = Pair("Intentar cruzar el río", Destinations.ScreenCruzarRio.ruta),
        boton2 = Pair("Seguir por la orilla del río", Destinations.ScreenSeguirOrilla.ruta),
        boton3 = Pair("Volver al camino de tierra", Destinations.ScreenCamino.ruta),
        boton2Visible = !Keys.casaLlave
    )
}

@Composable
fun ScreenCruzarRio(navController: NavController) {
    ScreenDerrota(navController = navController,
        textoDeMuerte = "Tratas de cruzar el río agarrandote a una rama. No consigues flotar, te hundes y te lleva la corriente. " +
                "Has perdido.")
}

@Composable
fun ScreenSeguirOrilla(navController: NavController) {

    Screen(
        navController = navController, idImagen = R.drawable.mochila,
        texto = "Te encuentras una mochila abandonada en un árbol al lado del río. " +
                "No se puede continuar ya que los árboles bloquean el camino...",
        boton1 = Pair("Registrar mochila", Destinations.ScreenEncontrarLlave.ruta),
        boton2 = Pair("Volver atrás", Destinations.ScreenRio.ruta),
        boton3 = Pair("", ""),
        boton3Visible = false
    )
}

@Composable
fun ScreenEncontrarLlave(navController: NavController) {
    Keys.casaLlave = true
    Screen(
        navController = navController, idImagen = R.drawable.mochila,
        texto = "Encuentras una llave.",
        boton1 = Pair("Volver atrás", Destinations.ScreenRio.ruta),
        boton2 = Pair("", ""),
        boton3 = Pair("", ""),
        boton2Visible = false,
        boton3Visible = false
    )
}

@Composable
fun ScreenDerrota(navController: NavController, textoDeMuerte:String) {

    Keys.resetKeys()

    systemBarColor(color = Color(0xFFCA3D4E))

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCA3D4E))
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = textoDeMuerte,
            color = Color.White,
            fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        GenericButton(
            navController = navController,
            ruta = Destinations.ScreenCaminoStart.ruta,
            texto = "Jugar de nuevo"
        )
    }
}


@Composable
fun ScreenVictoria(navController: NavController) {

    Keys.resetKeys()

    systemBarColor(color = Color(0xFF52A567))

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF52A567))
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Has conseguido escapar. Te despiertas y era todo un sueño.",
            color = Color.White,
            fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        GenericButton(
            navController = navController,
            ruta = Destinations.ScreenCaminoStart.ruta,
            texto = "Jugar de nuevo"
        )
    }
}


@Composable
fun Screen(
    navController: NavController, idImagen: Int, texto: String, boton1: Pair<String, String>,
    boton2: Pair<String, String>, boton3: Pair<String, String>, boton1Visible: Boolean = true,
    boton2Visible: Boolean = true, boton3Visible: Boolean = true
) {

    systemBarColor(color = Color(0xFF52A567))

    //Contenedor Imagen
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF2B5F38))
            .padding(10.dp)
    ) {

        //Elevador de superficie
        Box(
            Modifier
                .fillMaxSize()
        ) {

            //Imagen
            Image(
                painterResource(idImagen),
                contentDescription = "Fondo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
            )

            //Contenido sobre imagen
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .background(Color.Transparent),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Texto
                Text(
                    text = texto,
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(30.dp))

                //Botones
                if (boton1Visible) {
                    GenericButton(
                        navController = navController,
                        ruta = boton1.second,
                        texto = boton1.first
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                if (boton2Visible) {
                    GenericButton(
                        navController = navController,
                        ruta = boton2.second,
                        texto = boton2.first
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                if (boton3Visible) {
                    GenericButton(
                        navController = navController,
                        ruta = boton3.second,
                        texto = boton3.first
                    )
                }
            }
        }
    }
}

@Composable
fun GenericButton(navController: NavController, ruta: String, texto: String) {
    OutlinedButton(
        modifier = Modifier.background(Color.Transparent),
        onClick = { navController.navigate(ruta) },
        border = BorderStroke(1.dp, Color.White),
        colors = ButtonDefaults
            .outlinedButtonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color(0xFF2B5F38)
            )
    ) {
        Text(text = texto, color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun systemBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = false
        )
    }
}
