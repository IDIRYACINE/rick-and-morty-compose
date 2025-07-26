package com.idir.rickandmorty.features.home.state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.services.ServiceGateway
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    val characters = mutableStateListOf<RickAndMortyCharacterHeader>()
    private var hasLoadedInitial = false

    private var lastFilter: LoadCharactersParams? = null

    fun loadCharacters(newFilter: LoadCharactersParams, reset: Boolean) {
        viewModelScope.launch {
            val result = ServiceGateway.instance
                .getCharactersService()
                .loadCharacters(newFilter)

            if (reset) {
                characters.clear()
                characters.addAll(result.results)
            } else {
                characters.addAll(result.results)
            }

            lastFilter = newFilter
            hasLoadedInitial = true
        }
    }


    fun hasLoadedInitialPage(): Boolean = hasLoadedInitial




}