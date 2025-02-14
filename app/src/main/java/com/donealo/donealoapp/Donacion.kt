package com.donealo.donealoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "donaciones")
data class Donacion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // id autogenerado
    val nombre: String,
    val descripcion: String,
    val categoria: String
)
