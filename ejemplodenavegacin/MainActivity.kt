package es.uva.inf5g.psm.ejemplodenavegacin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import es.uva.inf5g.psm.ejemplodenavegacin.ui.theme.EjemploDeNavegaciónTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            EjemploDeNavegaciónTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        MyApp()
                    }
                }
            }

        }
    }
}


@Composable
fun MyApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "firstscreen"
    ) {

        composable("firstscreen") {
            FirstScreen(
                onNavigateToSecondScreen = { name ->
                    navController.navigate("secondscreen/$name")
                }
            )
        }

        composable("secondscreen/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Sin nombre"

            SecondScreen(
                name = name,
                onNavigateToThirdScreen = { age ->
                    navController.navigate("thirdscreen/$name/$age")
                }
            )
        }

        composable("thirdscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Sin nombre"
            val age = backStackEntry.arguments?.getString("age") ?: "Sin edad"

            ThirdScreen(
                name = name,
                age = age,
                onNavigateToFirstScreen = {
                    navController.navigate("firstscreen")
                }
            )
        }
    }
}

