package com.idir.rickandmorty.services.characters

import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.core.mocks.mockCharacter
import com.idir.rickandmorty.core.mocks.mockCharacterHeaderList
import com.idir.rickandmorty.core.ports.ICharacterService
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.services.api.NetworkClient
import com.idir.rickandmorty.services.characters.responses.LoadCharactersApiResponse
import com.idir.rickandmorty.services.characters.responses.PageInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterServiceImp(private val networkClient: NetworkClient) : ICharacterService {

    override suspend fun loadCharacters(params: LoadCharactersParams): LoadCharactersApiResponse {



        return withContext(Dispatchers.IO) {

            return@withContext LoadCharactersApiResponse(
                results = mockCharacterHeaderList,
                info = PageInfo()
            )
        }

    }

    override suspend fun getCharacter(id: Int): RickAndMortyCharacter? {


        return withContext(Dispatchers.IO) {


            return@withContext mockCharacter
        }
    }

}