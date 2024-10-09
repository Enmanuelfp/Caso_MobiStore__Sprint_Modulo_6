package com.bootcamp.caso_mobistore__sprint_modulo_6.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.Product
import com.bootcamp.caso_mobistore__sprint_modulo_6.repository.ProductsRepository
import com.bootcamp.caso_mobistore__sprint_modulo_6.state.ProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    var state by mutableStateOf(ProductState())
        private set

    val product: Flow<List<Product>> by lazy {
        repository.getAllProductRoom()
    }

    fun getAllApi() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getNewProductApi()
                Log.d("Products", repository.getNewProductApi().toString())
            }
        }
    }

    fun getProductById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getProductById(id)
                state = state.copy(
                    name = result.name,
                    price = result.price,
                    image = result.image,
                    description = result.description,
                    lastPrice = result.lastPrice,
                    credit = result.credit
                )
            }
        }
    }

    fun clean() {
        state = state.copy(
            name = "",
            price = 0,
            image = "",
            description = "",
            lastPrice = 0,
            credit = false
        )

    }
}