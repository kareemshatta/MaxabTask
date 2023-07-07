package com.kareem.maxabtask.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.kareem.maxabtask.R
import com.kareem.maxabtask.ui.theme.MaxabTaskTheme
import com.kareem.maxabtask.utils.AppNavigationActions
import com.kareem.maxabtask.utils.SetupNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaxabTaskTheme {
                this.window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    AppNavigationActions(navController)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetupNavGraph(
                        navController = navController,
                        window = window,
                        navigationActions = navigationActions
                    )
                }
            }
        }
    }
}
