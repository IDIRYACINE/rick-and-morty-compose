@file:Suppress("UNUSED", "UNUSED_PARAMETER", "UNUSED_VARIABLE", "UNUSED_EXPRESSION")

package com.idir.rickandmorty.features.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.idir.rickandmorty.features.home.hooks.CharactersLoaderHandler
import com.idir.rickandmorty.features.home.state.HomeViewModel
import com.idir.rickandmorty.features.home.state.LocalHomeViewModel
import com.idir.rickandmorty.features.home.widgets.CharacterGrid
import com.idir.rickandmorty.features.home.widgets.EmptyGrid
import com.idir.rickandmorty.features.state.LocalAppState
import com.idir.rickandmorty.ui.components.Searchbar
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map


data class ViewHomeParams(
    val onCharacterClick: (Int) -> Unit = {}
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewHome(params: ViewHomeParams = ViewHomeParams(), viewModel: HomeViewModel) {
    val appState = LocalAppState.current
    val nameFlow = remember {
        appState.filtersState.filters
            .map { it.name }
            .distinctUntilChanged()
    }

    val queryVal by nameFlow.collectAsState(initial = "")

    val characters = viewModel.characters
    val gridState = rememberLazyGridState()


    CompositionLocalProvider(LocalHomeViewModel provides viewModel) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {

                Searchbar(
                    modifier = Modifier
                        .fillMaxWidth(),
                    initialValue = queryVal,
                    onValueUpdate = { it ->
                        appState.filtersState.updateFilters(
                            name = it,
                            species = appState.filtersState.filters.value.species,
                            gender = appState.filtersState.filters.value.gender,
                            status = appState.filtersState.filters.value.status,
                            type = appState.filtersState.filters.value.type
                        )
                    },
                    onButtonClick = {
                        appState.toggleModal()
                    }
                )

                CharactersLoaderHandler(viewModel, gridState)

                if (!characters.isEmpty())
                    CharacterGrid(
                        items = characters,
                        modifier = Modifier
                            .fillMaxSize(),
                        gridState = gridState
                    )
                else
                    EmptyGrid(modifier = Modifier.fillMaxSize())
            }
        }

    }
}
