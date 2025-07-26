package com.idir.rickandmorty.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.idir.rickandmorty.R
import com.idir.rickandmorty.ui.components.fields.search.FieldSearch
import com.idir.rickandmorty.ui.components.fields.search.FieldSearchParams

@Composable
fun Searchbar(
    modifier: Modifier = Modifier,
    onValueUpdate: (String) -> Unit = { _ -> },
    onButtonClick: () -> Unit = {},
    initialValue: String? = null
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 1.dp,
        shadowElevation = 1.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FieldSearch(
                initialValue = initialValue,
                params = FieldSearchParams(
                    onSearch = onValueUpdate,
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onButtonClick,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Tune,
                    contentDescription = stringResource(R.string.filters),
                )
            }
        }
    }
}
