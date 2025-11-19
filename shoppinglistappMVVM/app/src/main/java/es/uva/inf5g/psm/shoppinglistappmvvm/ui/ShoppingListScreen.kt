package es.uva.inf5g.psm.shoppinglistappmvvm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.uva.inf5g.psm.shoppinglistappmvvm.model.ShoppingItem
import es.uva.inf5g.psm.shoppinglistappmvvm.ui.components.ShoppingItemEditor
import es.uva.inf5g.psm.shoppinglistappmvvm.ui.components.ShoppingListItem
import es.uva.inf5g.psm.shoppinglistappmvvm.viewmodel.ShoppingListViewModel

@Composable
fun ShoppingListScreen(viewModel: ShoppingListViewModel) {

    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var itemToEdit by remember { mutableStateOf<ShoppingItem?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Button(
            onClick = {
                itemToEdit = null
                itemName = ""
                itemQuantity = ""
                showDialog = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Añadir Item")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.items.value, key = { it.id }) { item ->
                ShoppingListItem(
                    item = item,
                    onEditClick = {
                        itemToEdit = item
                        itemName = item.name
                        itemQuantity = item.quantity.toString()
                        showDialog = true
                    },
                    onDeleteClick = { viewModel.removeItem(item) }
                )
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(if (itemToEdit == null) "Añadir artículo" else "Editar artículo") },
            text = {
                Column {
                    // Reutilizamos el editor composable para el contenido del diálogo
                    ShoppingItemEditor(
                        name = itemName,
                        quantity = itemQuantity,
                        onNameChange = { itemName = it },
                        onQuantityChange = { itemQuantity = it.filter(Char::isDigit) }
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    val name = itemName.trim()
                    val qty = itemQuantity.toIntOrNull() ?: 0
                    if (name.isNotEmpty() && qty > 0) {
                        if (itemToEdit == null) {
                            viewModel.addItem(name, qty)
                        } else {
                            viewModel.editItem(itemToEdit!!, name, qty)
                        }
                        showDialog = false
                        itemName = ""
                        itemQuantity = ""
                        itemToEdit = null
                    }
                }) { Text("Guardar") }
            },
            dismissButton = {
                Button(onClick = {
                    showDialog = false
                    itemToEdit = null
                }) { Text("Cancelar") }
            }
        )
    }
}