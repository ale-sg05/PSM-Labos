package es.uva.inf5g.psm.shoppinglistappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import es.uva.inf5g.psm.shoppinglistappmvvm.ui.ShoppingListScreen
import es.uva.inf5g.psm.shoppinglistappmvvm.viewmodel.ShoppingListViewModel
import es.uva.inf5g.psm.shoppinglistappmvvm.ui.theme.ShoppinglistappMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ShoppinglistappMVVMTheme {
                val vm: ShoppingListViewModel = viewModel()
                ShoppingListScreen(viewModel = vm)
            }
        }
    }
}
