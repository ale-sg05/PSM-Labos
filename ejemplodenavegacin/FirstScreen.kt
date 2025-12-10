package es.uva.inf5g.psm.ejemplodenavegacin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(onNavigateToSecondScreen: (String) -> Unit) {

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Primera Pantalla", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Introduce tu nombre") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNavigateToSecondScreen(name) }) {
            Text("Ir a la segunda pantalla")
        }
    }
}
