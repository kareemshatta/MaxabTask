package com.kareem.maxabtask.utils


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kareem.maxabtask.ui.recent_screen.RecentScreen
import com.kareem.maxabtask.ui.search_screen.SearchScreen
import com.kareem.maxabtask.ui.shared_components.bottom_bar.BottomBarItem
import com.kareem.maxabtask.ui.top_rated_screen.TopRatedScreen

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun SetupBottomNavGraph(
    navController: NavHostController,
    bottomBarNavigationActions: BottomBarNavigationActions,
    startDestination: String = BottomBarItem.Recent.route,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(route = BottomBarItem.Recent.route) {
            RecentScreen(navigationActions = bottomBarNavigationActions)
        }
        composable(route = BottomBarItem.TopRated.route) {
            TopRatedScreen(navigationActions = bottomBarNavigationActions)
        }
        composable(route = BottomBarItem.Search.route) {
            SearchScreen(navigationActions = bottomBarNavigationActions)
        }
    }
}