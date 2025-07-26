package com.idir.rickandmorty.ui.components.fields.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.TextFieldColors
import androidx.compose.ui.graphics.vector.ImageVector

data class FieldSearchParams(
    val placeholder: String = "Search...",
    val debounceMillis: Long = 500L,
    val leadingIcon: ImageVector = Icons.Default.Search,
    val onSearch: (String) -> Unit,
    val colors: TextFieldColors? = null
)