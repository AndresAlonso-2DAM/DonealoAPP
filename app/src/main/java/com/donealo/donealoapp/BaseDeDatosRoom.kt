package com.donealo.donealoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Donacion::class], version = 1)
abstract class BaseDeDatosRoom : RoomDatabase() {
    abstract fun donacionDAO(): DonacionDAO

    companion object {
        @Volatile
        private var INSTANCIA: BaseDeDatosRoom? = null

        fun obtenerBaseDeDatos(contexto: Context): BaseDeDatosRoom {
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    contexto.applicationContext,
                    BaseDeDatosRoom::class.java,
                    "BaseDeDatosDonaciones"
                ).build()
                INSTANCIA = instancia
                instancia
            }
        }
    }
}
