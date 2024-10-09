package com.bootcamp.caso_mobistore__sprint_modulo_6.di

import com.bootcamp.caso_mobistore__sprint_modulo_6.repository.ProductsRepository
import com.bootcamp.caso_mobistore__sprint_modulo_6.repository.ProductsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun productRepository(repositoryImp: ProductsRepositoryImp): ProductsRepository
}