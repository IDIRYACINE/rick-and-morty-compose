package com.idir.rickandmorty.ui.components.fields.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class FieldSearchState(
    initialQuery: String = ""
) {
    var query by mutableStateOf(initialQuery)
        private set

    fun updateQuery(newValue: String) {
        query = newValue
    }
}