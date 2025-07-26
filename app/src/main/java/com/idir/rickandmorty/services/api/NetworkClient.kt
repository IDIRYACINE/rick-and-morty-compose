package com.idir.rickandmorty.services.api

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient

class NetworkClient(private val baseUrl:String = "https://rickandmortyapi.com/api" ) {
    public val okHttpClient: OkHttpClient = OkHttpClient()






    fun apiLoadCharactersPageUrl(): HttpUrl {
        return "$baseUrl/character".toHttpUrlOrNull()
            ?: throw IllegalArgumentException("Invalid URL")
    }

    fun apiLoadCharacterDetailsUrl(id: Int): HttpUrl {
        return "$baseUrl/character/$id".toHttpUrlOrNull()
            ?: throw IllegalArgumentException("Invalid URL")
    }



}