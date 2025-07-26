package com.idir.rickandmorty.ui.components.fields.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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

@Composable
fun FieldSearch(
    modifier: Modifier = Modifier,
    params: FieldSearchParams,
    initialValue: String? = null
) {
    val coroutineScope = rememberCoroutineScope()
    var debounceJob by remember { mutableStateOf<Job?>(null) }
    val myVal = remember { mutableStateOf(initialValue ?: "") }

    OutlinedTextField(
        value = myVal.value,
        onValueChange = {
            myVal.value = it
            debounceJob?.cancel()
            debounceJob = coroutineScope.launch {
                delay(params.debounceMillis)
                params.onSearch(it)
            }
        },
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(params.placeholder) },
        singleLine = true,
        trailingIcon = {
            if (myVal.value.isNotEmpty()) {
                IconButton(onClick = {
                    myVal.value = ""
                    params.onSearch("") // Optionally clear search immediately
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear"
                    )
                }
            }
        },
        colors = params.colors ?: OutlinedTextFieldDefaults.colors()
    )
}
