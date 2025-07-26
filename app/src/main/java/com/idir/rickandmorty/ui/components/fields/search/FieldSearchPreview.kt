package com.idir.rickandmorty.ui.components.fields.search

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class SearchFieldParamsProvider : PreviewParameterProvider<FieldSearchParams> {
    override val values = sequenceOf(
        FieldSearchParams(
            placeholder = "Search...",
            debounceMillis = 300L,
            onSearch = {}
        )
    )
}

@Preview
@Composable
fun SearchFieldPreview(
    @PreviewParameter(SearchFieldParamsProvider::class) params: FieldSearchParams
) {
    FieldSearch(
        params = params,
    )
}