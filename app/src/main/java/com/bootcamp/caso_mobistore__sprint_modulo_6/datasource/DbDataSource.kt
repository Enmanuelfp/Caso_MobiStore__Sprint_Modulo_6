package com.bootcamp.caso_mobistore__sprint_modulo_6.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.Product
import com.bootcamp.caso_mobistore__sprint_modulo_6.model.ProductDao

@Database(
    entities = [Product::class],
    version = 1
)

abstract class DbDataSource:RoomDatabase(){
    abstract fun productDao():ProductDao
}