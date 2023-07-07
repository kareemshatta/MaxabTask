@file:OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)

package com.kareem.maxabtask.ui.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kareem.maxabtask.ui.shared_components.bottom_bar.CustomBottomBar
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_bottom_bar_height
import com.kareem.maxabtask.utils.AppNavigationActions
import com.kareem.maxabtask.utils.BottomBarNavigationActions
import com.kareem.maxabtask.utils.SetupBottomNavGraph


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(navigationActions: AppNavigationActions) {
    val navController = rememberNavController()
    val bottomBarNavigationActions = BottomBarNavigationActions(navController)

    Scaffold(
        bottomBar = {
            AppBottomBar(navController)
        }
    ) { innerPadding ->
        SetupBottomNavGraph(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            bottomBarNavigationActions = bottomBarNavigationActions,
        )
    }
}

@Composable
fun AppBottomBar(
    navController: NavHostController
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height( dim_bottom_bar_height.dp)
            .background(Color.Transparent)
    ) {
        CustomBottomBar(navController = navController)
    }
}
