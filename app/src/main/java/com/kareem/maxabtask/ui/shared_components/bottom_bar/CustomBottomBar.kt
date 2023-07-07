package com.kareem.maxabtask.ui.shared_components.bottom_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kareem.maxabtask.ui.theme.*
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_bottom_bar_height
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_bottom_radius
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_elevation
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_small
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_xxxlarge

var parentRoute = ""

@Composable
fun CustomBottomBar(navController: NavController) {

    val bottomBarItems = listOf(
        BottomBarItem.Recent,
        BottomBarItem.TopRated,
        BottomBarItem.Search
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination


    if (isParentRoute(currentDestination?.route.toString())) {
        parentRoute = currentDestination?.route.toString()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(dim_bottom_bar_height.dp)
            .background(Gray1000),
        verticalAlignment = CenterVertically
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(dim_bottom_bar_height.dp)
                .graphicsLayer {
                    shadowElevation = dim_elevation.toFloat()
                    shape = RoundedCornerShape(
                        topStart = dim_bottom_radius.dp,
                        topEnd = dim_bottom_radius.dp,
                        0.dp, 0.dp
                    )
                    clip = true
                    spotShadowColor = ShadowColor
                }
                .background(White),
            verticalAlignment = CenterVertically
        ) {
            bottomBarItems.forEach { item ->
                BottomBarItemScreen(item = item, currentDestination, navController)
            }
        }
    }

}

@Composable
fun RowScope.BottomBarItemScreen(
    item: BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavController
) {
    val isSelected = currentDestination?.hierarchy?.any {
        it.route == item.route
    } == true || parentRoute == item.route

    BottomNavigationItem(
        label = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = item.title,
                style = MaterialTheme.typography.caption.copy(
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            )
        },
        icon = {
            Image(
                modifier = Modifier.padding(bottom = dim_small.dp).size(dim_xlarge.dp),
                painter = painterResource(id = if (isSelected) item.selectedIcon else item.unselectedIcon),
                contentDescription = item.route
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == item.route
        } == true || parentRoute == item.route,
        selectedContentColor = Primary,
        unselectedContentColor = Gray500,
        onClick = {
            navController.popBackStack(BottomBarItem.Recent.route, inclusive = false)
            navController.navigate(route = item.route)
        }
    )
}

fun isParentRoute(route: String) = when (route) {
    BottomBarItem.Recent.route,
    BottomBarItem.TopRated.route,
    BottomBarItem.Search.route
    -> true
    else -> false
}

@Preview
@Composable
fun PreviewBottomBar() {
    CustomBottomBar(rememberNavController())
}