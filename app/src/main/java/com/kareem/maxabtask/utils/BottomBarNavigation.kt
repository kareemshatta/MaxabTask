package com.kareem.maxabtask.utils


import androidx.navigation.NavHostController
import com.kareem.maxabtask.ui.shared_components.bottom_bar.BottomBarItem

object BottomBarDestinations {

}


object BottomBarArguments {
}

/**
 * Models the navigation actions in the bottom bar.
 */
class BottomBarNavigationActions(private val navController: NavHostController) {

    val popBackStack: () -> Unit = {
        if (navController.previousBackStackEntry != null)
            navController.popBackStack()
        else
            navController.navigate(route = BottomBarItem.Recent.route)
    }

}
