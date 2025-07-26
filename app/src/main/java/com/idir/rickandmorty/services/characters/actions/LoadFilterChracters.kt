package com.idir.rickandmorty.services.characters.actions

import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.services.api.LoadCharacterApiQueryParams
import okhttp3.HttpUrl


fun loadFilterCharacters(params: LoadCharactersParams, urlBuilder: HttpUrl.Builder) {

    params.name?.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.NAME, params.name)
    }

    params.gender?.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.GENDER, params.gender.toString())
    }


    params.type?.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.TYPE, params.type)
    }


    params.status?.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.STATUS, params.status.toString())
    }


    params.species?.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.SPECIES, params.species)
    }


    params.page.let {
        urlBuilder.addQueryParameter(LoadCharacterApiQueryParams.PAGE, (params.page + 1).toString())

    }

}