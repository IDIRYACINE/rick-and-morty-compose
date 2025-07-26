package com.idir.rickandmorty.services.characters

import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.core.ports.ICharacterService
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.services.api.NetworkClient
import com.idir.rickandmorty.services.characters.actions.loadFilterCharacters
import com.idir.rickandmorty.services.characters.responses.LoadCharacterDetailsApiResponse
import com.idir.rickandmorty.services.characters.responses.LoadCharactersApiResponse
import com.idir.rickandmorty.services.mappers.GsonMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Request
import java.io.IOException

class CharacterServiceImp(private val networkClient: NetworkClient) : ICharacterService {

    override suspend fun loadCharacters(params: LoadCharactersParams): LoadCharactersApiResponse {


        val baseUrl = networkClient.apiLoadCharactersPageUrl();

        val urlWithParams = baseUrl.newBuilder();


        loadFilterCharacters(params, urlWithParams)

        val reqUrl = urlWithParams.build()

        val request = Request.Builder()
            .url(reqUrl)
            .build()

        return withContext(Dispatchers.IO) {
            var parsedResponse: LoadCharactersApiResponse = LoadCharactersApiResponse.empty()
            try {
                val response = networkClient.okHttpClient.newCall(request).execute()
                response.use { res ->
                    if (res.isSuccessful) {
                        val body = res.body.string()
                        body.let {
                            val result =
                                body.let { GsonMapper.fromJson<LoadCharactersApiResponse>(it) }
                            if (result != null) {
                                parsedResponse = result
                            }
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()

            }
            return@withContext parsedResponse
        }

    }

    override suspend fun getCharacter(id: Int): RickAndMortyCharacter? {
        val reqUrl = networkClient.apiLoadCharacterDetailsUrl(id);

        val request = Request.Builder()
            .url(reqUrl)
            .build();

        return withContext(Dispatchers.IO) {
            var parsedCharacter: RickAndMortyCharacter? = null

            try {
                val response = networkClient.okHttpClient.newCall(request).execute()

                response.use { res ->
                    if (res.isSuccessful) {
                        val body = res.body.string()
                        parsedCharacter = GsonMapper.fromJson<LoadCharacterDetailsApiResponse>(body)

                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return@withContext parsedCharacter
        }
    }

}