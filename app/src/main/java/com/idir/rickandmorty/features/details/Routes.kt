package com.idir.rickandmorty.features.details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.idir.rickandmorty.application.router.Routes
import com.idir.rickandmorty.features.details.view.ViewCharacterDetails
import com.idir.rickandmorty.features.details.view.ViewCharacterDetailsParams


fun NavGraphBuilder.detailNavigation(onBack: () -> Unit = {}) {
    composable(
        route = Routes.Detail.route,
        arguments = listOf(navArgument("characterId") { type = NavType.IntType })
    ) { backStackEntry ->
        val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0

        ViewCharacterDetails(ViewCharacterDetailsParams(characterId))
    }
}
