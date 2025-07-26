package com.idir.rickandmorty.features.home.hooks

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import com.idir.rickandmorty.features.filters.state.FiltersViewModel
import com.idir.rickandmorty.features.home.state.HomeViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun CharactersLoaderHandler(
    homeViewModel: HomeViewModel,
    filtersViewModel: FiltersViewModel,
    gridState: LazyGridState,
    buffer: Int = 6
) {
    val currentFilters by filtersViewModel.filters.collectAsState()

    LaunchedEffect(currentFilters) {
        if (filtersViewModel.shouldLoadOnNewFilter(currentFilters)) {
            val reset = filtersViewModel.shouldResetPage(currentFilters)
            val filterToUse = if (reset) currentFilters.copy(page = 0) else currentFilters

            homeViewModel.loadCharacters(filterToUse, reset)
        }
    }

    val shouldLoadMore = remember {
        derivedStateOf {
            val layoutInfo = gridState.layoutInfo
            val totalItems = layoutInfo.totalItemsCount
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            lastVisibleItem >= (totalItems - buffer)
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .distinctUntilChanged()
            .collect { loadMore ->
                if (loadMore && homeViewModel.hasLoadedInitialPage()) {
                    filtersViewModel.nextPage()
                }
            }
    }
}