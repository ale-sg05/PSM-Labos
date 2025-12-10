package es.uva.inf5g.psm.ejemplodenavegacin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(
    name: String,
    age: String,
    onNavigateToFirstScreen: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Tercera Pantalla", fontSize = 24.sp)
        Text(text = "Nombre: $name", fontSize = 20.sp)
        Text(text = "Edad: $age", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToFirstScreen) {
            Text("Volver a la primera pantalla")
        }
    }
}
