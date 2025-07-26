package com.idir.rickandmorty.application.router

import androidx.navigation.NavController

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Detail : Routes("detail/{characterId}") {
        fun createRoute(characterId: Int) = "detail/$characterId"
    }
}

class Router(private val navController: NavController) {
    fun goToDetails(id: Int) {
        navController.navigate("detail/$id")
    }

    fun goBack() {
        navController.popBackStack()
    }

}
