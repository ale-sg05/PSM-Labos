package es.uva.inf5g.psm.recetasapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(CategoriesFetchState())
    val categoriesState: State<CategoriesFetchState> = _categoriesState

    data class CategoriesFetchState(
        val loading: Boolean = true,
        val categories: List<Category> = emptyList(),
        val error: String? = null
    )

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    categories = response.categories,
                    error = null
                )
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error obteniendo las categorías: ${e.message}"
                )
            }
        }
    }
}