package com.bootcamp.caso_mobistore__sprint_modulo_6.repository

import com.bootcamp.caso_mobistore__sprint_modulo_6.datasource.RestDataSource
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.Product
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductDao
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductResults
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ProductsRepository {
    suspend fun getNewProductApi(): ArrayList<ProductResults>
    suspend fun getProductById(id:Int): ProductResults
    fun getAllProductRoom():Flow<List<Product>>
}

class ProductsRepositoryImp @Inject constructor(
    private val dataSource: RestDataSource,
    private val productDao: ProductDao
) : ProductsRepository {
    override suspend fun getNewProductApi(): ArrayList<ProductResults> {
        val data = dataSource.getAllProducts()
        data.forEach{
            val product = Product(
                it.id,
                it.name,
                it.price,
                it.image,
                it.description,
                it.lastPrice,
                it.credit
            )
            productDao.insert(product)
        }
        return ArrayList(data)
    }

    override suspend fun getProductById(id: Int): ProductResults {
        val data = dataSource.getDetailsProductsById(id).body()!!
        val product = ProductResults(
            data.id,
            data.name,
            data.price,
            data.image,
            data.description,
            data.lastPrice,
            data.credit
        )
        return product
    }

    override  fun getAllProductRoom(): Flow<List<Product>> = productDao.getALL()

}