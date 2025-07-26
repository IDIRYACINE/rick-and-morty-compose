package com.idir.rickandmorty.features.filters.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.R
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.features.state.LocalAppState


@Composable
fun ButtonFiltersApply(params: LoadCharactersParams) {
    val filtersState = LocalAppState.current.filtersState
    val modalState = LocalAppState.current

    Button(
        onClick = {
            modalState.toggleModal(false)
            filtersState.updateFilters(
                name = filtersState.filters.value.name,
                species = params.species,
                type = params.type,
                gender = params.gender,
                status = params.status
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(stringResource(id = R.string.apply_filters))
    }
}


@Composable
fun ButtonFiltersReset() {
    val filtersState = LocalAppState.current.filtersState
    val modalState = LocalAppState.current

    Button(
        onClick = {
            filtersState.updateFilters(
                name = filtersState.filters.value.name,
                status = null,
                species = null,
                type = null,
                gender = null,
            )

            modalState.toggleModal(false)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text(stringResource(id = R.string.reset_filters))
    }
}
