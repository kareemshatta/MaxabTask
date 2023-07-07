package com.kareem.maxabtask.utils

import androidx.navigation.NavHostController

object AppDestinations {
    const val MAIN_SCREEN_ROUTE = "main_screen"
}

object AppArguments {
}


/**
 * Models the navigation actions in the app.
 */
class AppNavigationActions(private val navController: NavHostController) {
    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

}

