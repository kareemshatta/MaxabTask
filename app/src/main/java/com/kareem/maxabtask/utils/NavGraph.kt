package com.kareem.maxabtask.utils


import android.view.Window
import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kareem.maxabtask.ui.main_screen.MainScreen
import com.kareem.maxabtask.ui.recent_screen.RecentScreen
import com.kareem.maxabtask.ui.search_screen.SearchScreen
import com.kareem.maxabtask.ui.shared_components.bottom_bar.BottomBarItem
import com.kareem.maxabtask.ui.top_rated_screen.TopRatedScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    navigationActions: AppNavigationActions,
    window: Window,
    startDestination: String = AppDestinations.MAIN_SCREEN_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppDestinations.MAIN_SCREEN_ROUTE) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            MainScreen(navigationActions)
        }
    }
}
