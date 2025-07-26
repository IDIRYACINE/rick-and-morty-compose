package com.idir.rickandmorty.features.filters.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


data class FieldFilterParams(
    val placeholder: String = "Search...",
    val debounceMillis: Long = 500L,
    val onSearch: (String) -> Unit,
    val colors: TextFieldColors? = null
)

@Composable
fun FieldFilter(
    modifier: Modifier = Modifier,
    label: String = "Label",
    params: FieldFilterParams,
    initialValue: String? = null
) {
    val coroutineScope = rememberCoroutineScope()
    var debounceJob by remember { mutableStateOf<Job?>(null) }
    val myVal = remember { mutableStateOf(initialValue ?: "") }

    OutlinedTextField(
        label = { Text(label) },
        value = myVal.value,//state.query,
        onValueChange = {
//            state.updateQuery(it)
            myVal.value = it
            debounceJob?.cancel()
            debounceJob = coroutineScope.launch {
                delay(params.debounceMillis)
                params.onSearch(it)
            }
        },
        modifier = modifier
            .fillMaxWidth(),
        placeholder = { Text(params.placeholder) },

        singleLine = true,
        colors = params.colors ?: OutlinedTextFieldDefaults.colors()
    )
}