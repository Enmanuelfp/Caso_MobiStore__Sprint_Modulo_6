package com.bootcamp.caso_mobistore__sprint_modulo_6.datasource


import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductResults
import com.bootcamp.caso_mobistore__sprint_modulo_6.util.Constants.Companion.ENDPOINT_DETAILS
import com.bootcamp.caso_mobistore__sprint_modulo_6.util.Constants.Companion.ENDPOINT_PRODUCTS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestDataSource {

    @GET(ENDPOINT_PRODUCTS)
    suspend fun getAllProducts():ArrayList<ProductResults>

    @GET("${ENDPOINT_DETAILS}/{id}")
    suspend fun getDetailsProductsById(@Path(value = "id")id:Int):Response<ProductResults>
}