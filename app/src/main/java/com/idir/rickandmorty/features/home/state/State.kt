@file:Suppress("UNUSED", "UnusedImport", "UNUSED_PARAMETER")

package com.idir.rickandmorty.features.home.state

import com.idir.rickandmorty.core.entity.RickAndMortyCharacter
import com.idir.rickandmorty.services.characters.responses.PageInfo


data class CharactersLoaderState(
    val characters: List<RickAndMortyCharacter> = emptyList(),
    val pageInfos: PageInfo = PageInfo()
)