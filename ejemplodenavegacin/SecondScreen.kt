package es.uva.inf5g.psm.ejemplodenavegacin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, onNavigateToThirdScreen: (String) -> Unit) {

    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Segunda Pantalla", fontSize = 24.sp)
        Text(text = "Bienvenido $name", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Introduce tu edad") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (age.isNotBlank()) {
                onNavigateToThirdScreen(age)
            }
        }) {
            Text("Ir a la tercera pantalla")
        }
    }
}
