package com.kareem.maxabtask.ui.shared_components.movie_card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kareem.domain.models.MovieVM
import com.kareem.maxabtask.R
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_large
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_radius
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_small
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_tiny
import com.kareem.maxabtask.ui.theme.Dimen.Companion.movie_image_height
import com.kareem.maxabtask.ui.theme.Dimen.Companion.movie_image_width
import com.kareem.maxabtask.ui.theme.Gray200
import com.kareem.maxabtask.ui.theme.Gray900
import com.kareem.maxabtask.ui.theme.White

@Composable
fun MovieView(
    modifier: Modifier = Modifier,
    movieVM: MovieVM,
    onItemClicked: (movieId: String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(dim_radius.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onItemClicked(movieVM.id)
            },
        horizontalAlignment = CenterHorizontally
    ) {

        AsyncImage(
            model = movieVM.url,
            placeholder = painterResource(id = R.drawable.ic_movie_placehoder),
            error = painterResource(id = R.drawable.ic_movie_placehoder),
            contentDescription = "category image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(movie_image_width.dp)
                .height(movie_image_height.dp)
                .clip(RoundedCornerShape(dim_radius.dp))
                .border(
                    width = 1.dp,
                    color = Gray200,
                    shape = RoundedCornerShape(10.dp)
                )
                .background(White)
        )
        Spacer(modifier = Modifier.height(dim_small.dp))
        Text(
            text = movieVM.title,
            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Medium),
            color = Gray900,
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = dim_tiny.dp, end = dim_tiny.dp)
                .align(CenterHorizontally)
        )
    }
}