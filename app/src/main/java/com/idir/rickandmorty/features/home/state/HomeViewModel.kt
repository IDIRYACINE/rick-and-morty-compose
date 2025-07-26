package com.idir.rickandmorty.features.home.state

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader
import com.idir.rickandmorty.services.characters.responses.PageInfo

class HomeViewModel: ViewModel() {


    val characters = mutableStateListOf<RickAndMortyCharacterHeader>()
    val pageInfos = mutableStateOf(PageInfo())
    private var hasLoadedInitial = false


    fun update(newChars:List<RickAndMortyCharacterHeader>,newPageInfos:PageInfo,reset:Boolean=false){

        if(!reset) {
            characters.addAll(newChars)
        }
        else{
            characters.clear()
            characters.addAll((newChars))
        }
        pageInfos.value = newPageInfos
    }

    fun resetCharacters() {
        characters.clear()
        hasLoadedInitial = false
    }

    fun markInitialLoadComplete() {
        hasLoadedInitial = true
    }

    fun hasLoadedInitialPage(): Boolean = hasLoadedInitial


}