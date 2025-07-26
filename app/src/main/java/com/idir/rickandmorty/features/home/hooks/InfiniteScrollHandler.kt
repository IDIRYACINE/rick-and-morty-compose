package com.idir.rickandmorty.features.home.hooks

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import com.idir.rickandmorty.features.home.state.HomeViewModel
import com.idir.rickandmorty.features.state.LocalAppState
import com.idir.rickandmorty.services.ServiceGateway
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
@Composable
fun CharactersLoaderHandler(
    viewModel: HomeViewModel,
    gridState: LazyGridState,
    buffer: Int = 6
) {
    val filtersState = LocalAppState.current.filtersState
    val currentFilters by filtersState.filters.collectAsState()

    LaunchedEffect(Unit) {
        snapshotFlow { currentFilters }
            .distinctUntilChanged()
            .collectLatest { newFilter ->
                if (filtersState.shouldLoadOnNewFilter(newFilter)) {
                    val shouldResetPage = filtersState.shouldResetPage(newFilter)

                    val filterToUse = if (shouldResetPage) {
                        newFilter.copy(page = 0)
                    } else {
                        newFilter
                    }

                    val result = ServiceGateway.instance
                        .getCharactersService()
                        .loadCharacters(filterToUse)

                    filtersState.updateLastFilter(filterToUse)
                    viewModel.update(result.results, result.info, reset = shouldResetPage)
                    viewModel.markInitialLoadComplete()
                }
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
                if (loadMore && viewModel.hasLoadedInitialPage()) {
                    filtersState.nextPage()
                }
            }
    }
}