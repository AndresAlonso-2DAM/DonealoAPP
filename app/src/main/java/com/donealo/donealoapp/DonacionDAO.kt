package com.donealo.donealoapp

import androidx.room.*

@Dao
interface DonacionDAO {
    @Insert
    suspend fun insertarDonacion(donacion: Donacion)

    @Query("SELECT * FROM donaciones")
    suspend fun obtenerTodasLasDonaciones(): List<Donacion>

    @Delete
    suspend fun eliminarDonacion(donacion: Donacion)
}
