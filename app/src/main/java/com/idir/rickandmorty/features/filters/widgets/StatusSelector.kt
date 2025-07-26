package com.idir.rickandmorty.features.filters.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.idir.rickandmorty.core.entity.CharacterStatus

@Composable
fun StatusSelector(
    values: Array<CharacterStatus> = CharacterStatus.entries.toTypedArray(),
    selected: CharacterStatus? = null,
    onChanged: (CharacterStatus?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember { mutableStateOf(selected) }

    Box {
        OutlinedButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(text = selectedStatus?.toString()?.replaceFirstChar { it.uppercase() }
                ?: "Select Status")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("All") },
                onClick = {
                    selectedStatus = null
                    expanded = false
                    onChanged(null)
                }
            )
            values.forEach { status ->
                DropdownMenuItem(
                    text = { Text(status.toString().replaceFirstChar { it.uppercase() }) },
                    onClick = {
                        selectedStatus = status
                        expanded = false
                        onChanged(status)
                    }
                )
            }
        }
    }
}
