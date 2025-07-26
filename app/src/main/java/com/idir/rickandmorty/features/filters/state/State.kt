package com.idir.rickandmorty.features.filters.state

import androidx.lifecycle.ViewModel
import com.idir.rickandmorty.core.entity.CharacterGender
import com.idir.rickandmorty.core.entity.CharacterStatus
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class FiltersViewModel : ViewModel() {
    private val _filters = MutableStateFlow(
        LoadCharactersParams(
            reverse = false,
            pageSize = 20,
            page = 0,
            name = null,
            status = null,
            species = null,
            type = null,
            gender = null
        )
    )

    val filters: StateFlow<LoadCharactersParams> = _filters.asStateFlow()

    private var _lastFilter: LoadCharactersParams? = null

    fun shouldLoadOnNewFilter(newFilter: LoadCharactersParams): Boolean {
        return _lastFilter != newFilter
    }

    fun shouldResetPage(newFilter: LoadCharactersParams): Boolean {
        return _lastFilter?.let {
            newFilter.shouldResetPage(it)
        } ?: true
    }

    fun nextPage() {
        _filters.update { params ->
            params.copy(page = params.page + 1)
        }
    }

    fun updateLastFilter(newFilter: LoadCharactersParams) {
        _lastFilter = newFilter.copy()
    }



    fun updateFilters(
        name: String? = null,
        status: CharacterStatus? = null,
        species: String? = null,
        type: String? = null,
        gender: CharacterGender? = null
    ) {
        _filters.update { current ->
            current.copy(
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender,
                page = 0
            )
        }
    }
}