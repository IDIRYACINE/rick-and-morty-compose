package com.idir.rickandmorty.core.ports

import com.idir.rickandmorty.core.entity.CharacterGender
import com.idir.rickandmorty.core.entity.CharacterStatus
import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader
import com.idir.rickandmorty.services.characters.responses.LoadCharactersApiResponse


data class LoadCharactersParams(
    val reverse: Boolean = false,
    val pageSize:Int = 20,
    val page:Int = 0,
    val name: String? = null,
    val status: CharacterStatus? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: CharacterGender? = null
){
    fun shouldResetPage(other: LoadCharactersParams?): Boolean {
        if (other == null) return true

        return reverse != other.reverse ||
                name != other.name ||
                status != other.status ||
                species != other.species ||
                type != other.type ||
                gender != other.gender
    }

}

interface ICharacterService {
    suspend fun loadCharacters(params:LoadCharactersParams): LoadCharactersApiResponse
    suspend fun getCharacter(id:Int): RickAndMortyCharacter?

}