package com.idir.rickandmorty.services.characters.responses

import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader

data class PageInfo(
    val count: Int = 1,
    val pages: Int = 1,
    val next: String? = null,
    val prev: String? = null
)

class LoadCharactersApiResponse(
    val info: PageInfo,
    val results: List<RickAndMortyCharacterHeader>
) {
    companion object {
        fun empty(): LoadCharactersApiResponse {
            return LoadCharactersApiResponse(
                info = PageInfo(
                    count = 0,
                    pages = 1,
                    next = null,
                    prev = null
                ),
                results = emptyList()
            )
        }
    }
}
