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
import com.idir.rickandmorty.core.entity.CharacterGender


@Composable
fun GenderSelector(
    values: Array<CharacterGender> = CharacterGender.entries.toTypedArray(),
    selected: CharacterGender? = null,
    onChanged: (CharacterGender?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf(selected) }

    Box {
        OutlinedButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
            Text(text = selectedGender?.toString()?.replaceFirstChar { it.uppercase() }
                ?: "Select Gender")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("All") },
                onClick = {
                    selectedGender = null
                    expanded = false
                    onChanged(null)
                }
            )
            values.forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender.toString().replaceFirstChar { it.uppercase() }) },
                    onClick = {
                        selectedGender = gender
                        expanded = false
                        onChanged(gender)
                    }
                )
            }
        }
    }
}
