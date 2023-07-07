package com.kareem.maxabtask.ui.shared_components.bottom_bar

import com.kareem.maxabtask.R


sealed class BottomBarItem(
    var title: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val route: String
) {

    object Recent : BottomBarItem(
        title = "Now Playing",
        selectedIcon = R.drawable.ic_selected_recent,
        unselectedIcon = R.drawable.ic_unselected_recent,
        route = "NowPlaying"
    )

    object TopRated : BottomBarItem(
        title = "TopRated",
        selectedIcon = R.drawable.ic_selected_top_rated,
        unselectedIcon = R.drawable.ic_unselected_top_rated,
        route = "TopRated"
    )

    object Search :
        BottomBarItem(
            title = "Search",
            selectedIcon = R.drawable.ic_selected_search,
            unselectedIcon = R.drawable.ic_unselected_search,
            route = "Search"
        )
}