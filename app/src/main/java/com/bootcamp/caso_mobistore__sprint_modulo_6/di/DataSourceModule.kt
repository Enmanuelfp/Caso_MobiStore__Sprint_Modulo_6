package com.bootcamp.caso_mobistore__sprint_modulo_6.di

import android.content.Context
import androidx.room.Room
import com.bootcamp.caso_mobistore__sprint_modulo_6.datasource.DbDataSource
import com.bootcamp.caso_mobistore__sprint_modulo_6.datasource.RestDataSource
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductDao
import com.bootcamp.caso_mobistore__sprint_modulo_6.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun restDataSource(retrofit: Retrofit): RestDataSource =
        retrofit.create(RestDataSource::class.java)

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DbDataSource {

        return Room.databaseBuilder(
            context,
            DbDataSource::class.java,
            "product_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun productDao(db: DbDataSource): ProductDao = db.productDao()
}
