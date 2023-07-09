package com.kareem.maxabtask.ui.recent_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kareem.domain.models.MovieVM
import com.kareem.maxabtask.R
import com.kareem.maxabtask.ui.shared_components.header.Header
import com.kareem.maxabtask.ui.shared_components.movie_card.MovieView
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_large
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.maxabtask.ui.theme.Dimen.Companion.movie_image_height
import com.kareem.maxabtask.ui.theme.Dimen.Companion.movie_image_width
import com.kareem.maxabtask.ui.theme.Gray1000
import com.kareem.maxabtask.utils.BottomBarNavigationActions
import kotlin.math.ceil

@Composable
fun RecentScreen(navigationActions: BottomBarNavigationActions) {
    val movies = listOf(
        MovieVM("1","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
        MovieVM("2","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
        MovieVM("3","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
        MovieVM("4","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
        MovieVM("5","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
        MovieVM("6","aaaa", 1.5, "https://selectra.in/sites/selectra.in/files/2021-04/mobile-recharge-plans.png"),
    )

    Column(modifier = Modifier.fillMaxSize().background(Gray1000)) {
        Header(title = LocalContext.current.getString(R.string.now_playing_movies_title))
        Spacer(modifier = Modifier.height(dim_xlarge.dp))
        LazyVerticalGrid(
            userScrollEnabled = false,
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(start = dim_xlarge.dp, end = dim_xlarge.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dim_large.dp),
            horizontalArrangement = Arrangement.spacedBy(dim_large.dp)
        ) {
            items(movies.size) { index ->
                MovieView(
                    modifier = Modifier
                        .width(movie_image_width.dp),
                    movieVM = movies[index],
                    onItemClicked = {
                        //TODO add movie details screen navigation here
                    }
                )
            }
        }
    }
}