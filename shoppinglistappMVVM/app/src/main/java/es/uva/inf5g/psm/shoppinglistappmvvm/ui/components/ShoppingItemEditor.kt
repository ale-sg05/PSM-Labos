package es.uva.inf5g.psm.shoppinglistappmvvm.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingItemEditor(
    name: String,
    quantity: String,
    onNameChange: (String) -> Unit,
    onQuantityChange: (String) -> Unit
) {
    Column {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { onQuantityChange(it.filter(Char::isDigit)) },
            label = { Text("Cantidad") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            singleLine = true
        )
    }
}
