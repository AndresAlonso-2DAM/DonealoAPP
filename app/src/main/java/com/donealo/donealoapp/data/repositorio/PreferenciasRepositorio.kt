package com.donealo.donealoapp.data.repositorio

import android.content.Context
import android.content.SharedPreferences

class PreferenciasRepositorio(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("PreferenciasApp", Context.MODE_PRIVATE)

    fun guardarModoOscuro(activado: Boolean) {
        prefs.edit().putBoolean("modo_oscuro", activado).apply()
    }

    fun obtenerModoOscuro(): Boolean {
        return prefs.getBoolean("modo_oscuro", false)
    }
}
