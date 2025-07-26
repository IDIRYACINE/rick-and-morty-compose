package com.idir.rickandmorty.services.mappers

import com.google.gson.Gson

object GsonMapper {
    val gson = Gson()

     inline fun <reified T> fromJson(json: String): T? {
        return try {
            gson.fromJson(json, T::class.java)
        } catch (e: Exception) {
            null // or log/throw if you prefer
        }
    }

    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }
}
