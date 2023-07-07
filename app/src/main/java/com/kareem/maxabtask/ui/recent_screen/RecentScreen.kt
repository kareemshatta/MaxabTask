package com.kareem.maxabtask.ui.recent_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.kareem.maxabtask.ui.theme.Gray500
import com.kareem.maxabtask.utils.BottomBarNavigationActions

@Composable
fun RecentScreen(navigationActions: BottomBarNavigationActions) {
    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray500),
    ) {

    }
}