package com.idir.rickandmorty.features.home

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.idir.rickandmorty.application.router.Routes
import com.idir.rickandmorty.features.home.state.HomeViewModel
import com.idir.rickandmorty.features.home.view.ViewHome
import com.idir.rickandmorty.features.home.view.ViewHomeParams

fun NavGraphBuilder.homeNavigation(navController: NavController) {
    composable(Routes.Home.route) { backStackEntry ->
        val viewModel: HomeViewModel = viewModel(backStackEntry)

        ViewHome(
            params = ViewHomeParams(
                onCharacterClick = { id ->
                    navController.navigate(Routes.Detail.createRoute(id))
                }
            ),
            viewModel = viewModel
        )
    }
}
