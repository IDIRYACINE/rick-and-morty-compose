package com.idir.rickandmorty.services.mappers

import android.util.Log
import com.google.gson.Gson

object GsonMapper {
    val gson = Gson()

     inline fun <reified T> fromJson(json: String): T? {
        return try {
            gson.fromJson(json, T::class.java)
        } catch (e: Exception) {
            Log.e("ErrorCatch","$e")
            null
        }
    }

}
