package com.idir.rickandmorty.features.home.widgets
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.application.responsive.WindowBreakpoint
import com.idir.rickandmorty.application.responsive.getWindowBreakpoint
import com.idir.rickandmorty.core.entity.RickAndMortyCharacterHeader
import com.idir.rickandmorty.core.mocks.mockCharacterHeaderList


@Composable
fun CharacterGrid(items: List<RickAndMortyCharacterHeader>,
                  modifier:Modifier=Modifier,
                  gridState: LazyGridState
                  ) {
    val breakpoint = getWindowBreakpoint()
    val gridCells = if (breakpoint == WindowBreakpoint.Compact)  1 else  2

    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCells),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        state = gridState

    ) {
        items(items) { item ->
            GridItem(item)
        }
    }
}

@Preview
@Composable
fun GridPreview() {
    MaterialTheme {
        val gridState = rememberLazyGridState()

        Surface {
            CharacterGrid(
                mockCharacterHeaderList, Modifier.fillMaxSize(),
                gridState = gridState
            )
        }
    }
}