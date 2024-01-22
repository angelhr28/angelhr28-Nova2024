@file:OptIn(ExperimentalMaterial3Api::class)

package com.angelhr28.novachallengeapp.ui.feature.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.angelhr28.novachallengeapp.ui.entity.ScreenNavigation
import com.angelhr28.novachallengeapp.ui.feature.LogoutScreenContent
import com.angelhr28.novachallengeapp.ui.feature.ProfileScreen
import com.angelhr28.novachallengeapp.ui.feature.ShapesScreenContent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {

    val uiState by viewModel.uiState.collectAsState()
    ScreenContent(viewModel, navController, uiState, viewModel::handleUiEvent)

}

@Composable
fun ScreenContent(
    viewModel: HomeViewModel,
    navController: NavHostController,
    uiState: UiState,
    sendUiEvent: (UiEvent) -> Job,
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val items = ScreenNavigation.entries
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(item.title) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                selectedItem.value.title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    )
                },
                content = { _ ->

                    when (selectedItem.value) {
                        ScreenNavigation.ShapesScreen -> ShapesScreenContent()
                        ScreenNavigation.ProfileScreen -> ProfileScreen(
                            viewModel = viewModel,
                            uiState = uiState
                        )

                        ScreenNavigation.LogoutScreen -> LogoutScreenContent(
                            navController = navController,
                            sendUiEvent = sendUiEvent
                        )
                    }
                }
            )
        }
    )
}