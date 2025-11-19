package es.uva.inf5g.psm.shoppinglistappmvvm.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import es.uva.inf5g.psm.shoppinglistappmvvm.model.ShoppingItem
import es.uva.inf5g.psm.shoppinglistappmvvm.repository.ShoppingRepository

class ShoppingListViewModel(
    private val repository: ShoppingRepository = ShoppingRepository()
) : ViewModel() {

    private val _items = mutableStateOf(repository.getItems())
    val items: State<List<ShoppingItem>> = _items

    fun addItem(name: String, quantity: Int) {
        val newItem = ShoppingItem(
            id = (_items.value.maxOfOrNull { it.id } ?: 0) + 1,
            name = name,
            quantity = quantity
        )
        repository.addItem(newItem)
        _items.value = repository.getItems()
    }

    fun removeItem(item: ShoppingItem) {
        repository.removeItem(item)
        _items.value = repository.getItems()
    }

    fun editItem(item: ShoppingItem, name: String, quantity: Int) {
        val updatedItem = item.copy(name = name, quantity = quantity)
        repository.updateItem(updatedItem)
        _items.value = repository.getItems()
    }
}