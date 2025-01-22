package com.donealo.donealoapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDeDatosSQLite(contexto: Context) : SQLiteOpenHelper(contexto, "Base De Donaciones", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE Donaciones (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nombre TEXT NOT NULL, " +
                    "descripcion TEXT NOT NULL, " +
                    "categoria TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Donaciones")
        onCreate(db)
    }

    // Operaciones CRUD
    fun insertarDonacion(donacion: Donacion) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("nombre", donacion.nombre)
            put("descripcion", donacion.descripcion)
            put("categoria", donacion.categoria)
        }
        db.insert("donaciones", null, values)
    }


    fun obtenerDonaciones(): List<Donacion> {
        val db = readableDatabase
        val listaDonaciones = mutableListOf<Donacion>()
        val cursor = db.rawQuery("SELECT * FROM donaciones", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"))
                val categoria = cursor.getString(cursor.getColumnIndexOrThrow("categoria"))

                val donacion = Donacion(id, nombre, descripcion, categoria)
                listaDonaciones.add(donacion)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return listaDonaciones
    }

    fun eliminarDonacion(id: Int) {
        val db = writableDatabase  // Utiliza directamente writableDatabase
        val args = arrayOf(id.toString())
        db.delete("donaciones", "id = ?", args)
    }


}
