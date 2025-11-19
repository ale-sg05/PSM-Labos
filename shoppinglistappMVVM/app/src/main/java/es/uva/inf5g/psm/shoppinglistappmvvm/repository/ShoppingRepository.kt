package es.uva.inf5g.psm.shoppinglistappmvvm.repository

import es.uva.inf5g.psm.shoppinglistappmvvm.model.ShoppingItem

class ShoppingRepository {

    private var _items = listOf(
        ShoppingItem(1, "Unicornio Inflable", 1),
        ShoppingItem(2, "Sombrero para Gatos", 3),
        ShoppingItem(3, "Bocadillo de Aire Fresco", 1),
        ShoppingItem(4, "Teletransportador Portátil", 1)
    )

    fun getItems(): List<ShoppingItem> = _items

    fun addItem(item: ShoppingItem) {
        _items = _items + item
    }

    fun removeItem(item: ShoppingItem) {
        _items = _items.filter { it.id != item.id }
    }

    fun updateItem(updatedItem: ShoppingItem) {
        _items = _items.map { if (it.id == updatedItem.id) updatedItem else it }
    }
}