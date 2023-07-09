package com.kareem.maxabtask.ui.recent_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.kareem.domain.models.MovieVM
import com.kareem.maxabtask.R
import com.kareem.maxabtask.ui.shared_components.header.Header
import com.kareem.maxabtask.ui.shared_components.movie_card.MovieView
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_large
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.maxabtask.ui.theme.Dimen.Companion.movie_image_width
import com.kareem.maxabtask.ui.theme.Gray1000
import com.kareem.maxabtask.utils.BottomBarNavigationActions

@Composable
fun RecentScreen(navigationActions: BottomBarNavigationActions) {

    val viewModel = hiltViewModel<RecentViewModel>()

    LaunchedEffect(key1 = true) {
        viewModel.getNowPlayingMovies()
    }
    val movies = viewModel.movies.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray1000)
    ) {
        Header(title = LocalContext.current.getString(R.string.now_playing_movies_title))
        Spacer(modifier = Modifier.height(dim_xlarge.dp))
        if (viewModel.screenLoading.collectAsState().value) {
            Dialog(onDismissRequest = {}) {
                CircularProgressIndicator()
            }
        } else {
            RecentMoviesResultPaging(
                rememberLazyListState(),
                viewModel,
                movies
            )
            LazyVerticalGrid(
                userScrollEnabled = true,
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .padding(start = dim_xlarge.dp, end = dim_xlarge.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(dim_large.dp),
                horizontalArrangement = Arrangement.spacedBy(dim_large.dp)
            ) {
                items(movies.size) { index ->
                    MovieView(
                        modifier = Modifier.width(movie_image_width.dp),
                        movieVM = movies[index],
                        onItemClicked = {
                            //TODO add movie details screen navigation here
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RecentMoviesResultPaging(
    scrollState: LazyListState,
    viewModel: RecentViewModel,
    results: List<MovieVM>
) {
    if (scrollState.firstVisibleItemIndex in (results.size - 5)..results.size && viewModel.pageInfoModel.hasNext)
        viewModel.getNowPlayingMovies()
}
