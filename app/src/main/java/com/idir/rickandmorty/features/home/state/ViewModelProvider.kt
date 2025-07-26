package com.idir.rickandmorty.features.home.state

import androidx.compose.runtime.staticCompositionLocalOf

val LocalHomeViewModel = staticCompositionLocalOf<HomeViewModel> {
    error("HomeViewModel not provided")
}
