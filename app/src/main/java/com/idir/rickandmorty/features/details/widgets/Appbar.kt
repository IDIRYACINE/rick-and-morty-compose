package com.idir.rickandmorty.features.details.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.idir.rickandmorty.application.router.LocalAppRouter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailsAppbar() {
    val router = LocalAppRouter.current
    val colorScheme = MaterialTheme.colorScheme

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Details",
                style = MaterialTheme.typography.titleLarge,
                color = colorScheme.onPrimary
            )
        },
        navigationIcon = {
            IconButton(onClick = { router.goBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorScheme.primary,
            scrolledContainerColor = colorScheme.primary
        )
    )
}