package com.idir.rickandmorty.application.router

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.idir.rickandmorty.features.details.detailNavigation
import com.idir.rickandmorty.features.filters.views.ModalFilters
import com.idir.rickandmorty.features.home.homeNavigation


@Composable
fun MyApp() {
    val navController = rememberNavController()
    val router = remember(navController) { Router(navController) }

    CompositionLocalProvider(LocalAppRouter provides router) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navController,
                startDestination = Routes.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                homeNavigation(navController)
                detailNavigation()
            }

            ModalFilters()


        }
    }

}
