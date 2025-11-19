package es.uva.inf5g.psm.shoppinglistappmvvm.model

data class ShoppingItem(
    val id: Int,
    val name: String,
    val quantity: Int,
    val isEditing: Boolean = false
)