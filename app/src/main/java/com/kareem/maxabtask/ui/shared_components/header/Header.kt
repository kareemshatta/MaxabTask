package com.kareem.maxabtask.ui.shared_components.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kareem.maxabtask.R
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_tiny
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_top_bar_height
import com.kareem.maxabtask.ui.theme.Dimen.Companion.dim_xlarge
import com.kareem.maxabtask.ui.theme.Gray100
import com.kareem.maxabtask.ui.theme.Gray1000
import com.kareem.maxabtask.ui.theme.Gray800
import com.kareem.maxabtask.ui.theme.White


@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier,
    showBack: Boolean = false,
    backClick: () -> Unit = {},
    LeadingContent: @Composable (modifier: Modifier) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(dim_top_bar_height.dp)
            .background(color = White)
    ) {
        if (showBack)
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left_black),
                contentDescription = "back btn",
                modifier = Modifier
                    .padding(dim_xlarge.dp)
                    .clickable {
                        backClick()
                    }
                    .align(Alignment.CenterStart)
            )

        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = Gray800,
            modifier = Modifier.align(Alignment.Center)
        )
        LeadingContent(Modifier.align(Alignment.CenterEnd))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(dim_tiny.dp)
                .background(brush = Brush.verticalGradient(listOf(Gray100, Gray1000)))
                .align(Alignment.BottomCenter)
        )
    }
}