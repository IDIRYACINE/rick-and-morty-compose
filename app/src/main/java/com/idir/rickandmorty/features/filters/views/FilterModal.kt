package com.idir.rickandmorty.features.filters.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.R
import com.idir.rickandmorty.core.ports.LoadCharactersParams
import com.idir.rickandmorty.features.filters.widgets.ButtonFiltersApply
import com.idir.rickandmorty.features.filters.widgets.ButtonFiltersReset
import com.idir.rickandmorty.features.filters.widgets.FieldFilter
import com.idir.rickandmorty.features.filters.widgets.FieldFilterParams
import com.idir.rickandmorty.features.filters.widgets.GenderSelector
import com.idir.rickandmorty.features.filters.widgets.StatusSelector
import com.idir.rickandmorty.features.state.LocalAppState


@Composable
fun ModalFilters() {

    val appState = LocalAppState.current
    val state = LocalAppState.current.modalState.collectAsState()
    val updatedFilters = remember { mutableStateOf(LoadCharactersParams()) }
    val filterState by appState.filtersState.filters.collectAsState()

    if (!state.value.isOpen) return

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                appState.toggleModal(false)
            }
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp)
                .widthIn(min = 280.dp, max = 400.dp)
        ) {
            StatusSelector(
                selected = filterState.status,
                onChanged = { it -> updatedFilters.value = updatedFilters.value.copy(status = it) })
            Spacer(Modifier.height(8.dp))
            GenderSelector(
                selected = filterState.gender,
                onChanged = { it -> updatedFilters.value = updatedFilters.value.copy(gender = it) })
            Spacer(Modifier.height(8.dp))
            FieldFilter(
                label = stringResource(id = R.string.species),
                initialValue = filterState.species,
                params = FieldFilterParams(
                    placeholder = stringResource(id = R.string.species),
                    onSearch = { it ->
                        updatedFilters.value = updatedFilters.value.copy(species = it)
                    })
            )

            Spacer(Modifier.height(8.dp))
            FieldFilter(
                label = stringResource(id = R.string.type),
                initialValue = filterState.type,
                params = FieldFilterParams(
                    placeholder = stringResource(id = R.string.type),
                    onSearch = { it ->
                        updatedFilters.value = updatedFilters.value.copy(type = it)
                    })
            )

            Spacer(Modifier.height(8.dp))
            ButtonFiltersApply(updatedFilters.value)
            Spacer(Modifier.height(8.dp))
            ButtonFiltersReset()

        }
    }
}