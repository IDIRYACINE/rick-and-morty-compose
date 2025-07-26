package com.idir.rickandmorty.application.router

import androidx.compose.runtime.staticCompositionLocalOf

val LocalAppRouter = staticCompositionLocalOf<Router> {
    error("No NavController provided")
}
