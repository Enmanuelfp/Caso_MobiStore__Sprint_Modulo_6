package com.bootcamp.caso_mobistore__sprint_modulo_6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val name: String,
    @ColumnInfo(name = "precio")
    val price: Int,
    @ColumnInfo(name = "imagen")
    val image: String,
    @ColumnInfo(name = "descripcion")
    val description: String?,
    @ColumnInfo(name = "ultimoPrecio")
    val lastPrice: Int?,
    @ColumnInfo(name = "credito")
    val credit: Boolean?
)
