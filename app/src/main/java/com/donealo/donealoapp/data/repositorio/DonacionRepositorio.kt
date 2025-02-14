package com.donealo.donealoapp.data.repositorio

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.donealo.donealoapp.data.modelo.Donacion

class DonacionRepositorio(context: Context) : SQLiteOpenHelper(context, "DonacionesDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val crearTabla = "CREATE TABLE Donaciones (id INTEGER PRIMARY KEY, nombre TEXT, descripcion TEXT)"
        db.execSQL(crearTabla)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Donaciones")
        onCreate(db)
    }

    fun insertarDonacion(donacion: Donacion) {
        val db = writableDatabase
        db.execSQL("INSERT INTO Donaciones (nombre, descripcion) VALUES (?, ?)", arrayOf(donacion.nombre, donacion.descripcion))
        db.close()
    }

    fun obtenerDonaciones(): List<Donacion> {
        val lista = mutableListOf<Donacion>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Donaciones", null)

        while (cursor.moveToNext()) {
            val donacion = Donacion(
                id = cursor.getInt(0),
                nombre = cursor.getString(1),
                descripcion = cursor.getString(2)
            )
            lista.add(donacion)
        }

        cursor.close()
        db.close()
        return lista
    }
}
