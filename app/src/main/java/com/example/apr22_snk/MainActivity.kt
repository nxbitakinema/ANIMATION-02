package com.example.apr22_snk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.apr22_snk.ui.theme.APR22_SNKTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APR22_SNKTheme {

                val screenState by remember { viewModel.screenState }

                Crossfade(
                    targetState = screenState, label = ""
                ) { state ->
                    when (state) {

                        is MainViewModel.UiState.Home -> {
                            DashboardComponent(viewModel)
                        }

                        is MainViewModel.UiState.Details -> {
                            Detail(state.carouselDataModel, viewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DashboardComponent(viewModel: MainViewModel) {

    val screen = remember { mutableStateOf(BottomNav.Home) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (screen.value) {
                BottomNav.Home -> HomeComponent(viewModel)
                else -> { Text(text = "Coming Soon")
                }
            }
        }
        BottomToolbar(screen)
    }
}

@Composable
fun BottomToolbar(screen: MutableState<BottomNav>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNav.values().forEach { nav ->
            Image(
                painter = painterResource(id = nav.icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .size(36.dp)
                    .padding(6.dp)
                    .clickable { screen.value = nav }
            )
        }
    }
}


enum class BottomNav(val route: String, val icon: Int, val title: String) {
    Home("home", R.drawable.ic_home, "Home"),
    Search("favorite", R.drawable.ic_heart, "Favorite"),
    Profile("profile", R.drawable.ic_profile, "Profile"),
    Favorites("cart", R.drawable.ic_shop, "Cart"),
    Settings("settings", R.drawable.ic_settings, "Settings")
}