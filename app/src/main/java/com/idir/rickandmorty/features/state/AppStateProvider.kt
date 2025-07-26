package com.idir.rickandmorty.features.state

import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppState = staticCompositionLocalOf<AppStateViewModel> {
    error("AppStateViewModel not provided")
}
