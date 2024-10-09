package com.bootcamp.caso_mobistore__sprint_modulo_6.utils

import com.bootcamp.caso_mobistore__sprint_modulo_6.di.RepositoryModule
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.Product
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductResults
import com.bootcamp.caso_mobistore__sprint_modulo_6.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
class FakeRepositoryModule {

    @Provides
    @Singleton
    fun productsRepository(): ProductsRepository = object : ProductsRepository {
        private val products = MutableStateFlow<List<Product>>(emptyList())

        override suspend fun getNewProductApi(): ArrayList<ProductResults> {
            val productList = products.value
            val newProduct = Product(
                id = productList.size + 1,
                name = "name ${productList.size}",
                price = (100 + productList.size * 10),
                image = "https://example.com/image${productList.size}.jpg",
                description = "description ${productList.size}",
                lastPrice = (90 + productList.size * 10),
                credit = true
            )
            products.value = products.value.toMutableList().apply { add(newProduct) }
            return ArrayList(products.value.map { product ->
                ProductResults(
                    product.id,
                    product.name,
                    product.price,
                    product.image,
                    product.description,
                    product.lastPrice,
                    product.credit
                )
            })
        }

        override suspend fun getProductById(id: Int): ProductResults {
            val product = products.value.find { it.id == id }
                ?: throw IllegalArgumentException("Product with ID $id not found")
            return ProductResults(
                product.id,
                product.name,
                product.price,
                product.image,
                product.description,
                product.lastPrice,
                product.credit
            )
        }

        override fun getAllProductRoom(): Flow<List<Product>> {
            return products
        }
    }
}
