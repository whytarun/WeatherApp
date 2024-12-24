package com.tv.weatherapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tv.weatherapp.presentation.home.HomeScreen
import com.tv.weatherapp.presentation.home.HomeViewModel
import com.tv.weatherapp.presentation.search.SearchScreen
import com.tv.weatherapp.presentation.search.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.HomeScreen.route
    ){
        composable(route = Route.HomeScreen.route){
           HomeScreen(
               navigateToSearch = {
                    navController.navigate(Route.SearchScreen.route)
                }
            )
        }

        composable(route = Route.SearchScreen.route){
            val searchViewModel :SearchViewModel = hiltViewModel()
            SearchScreen(
                state = searchViewModel.state,
                event = searchViewModel::onEvent,
                 onCitySelected ={
                   CoroutineScope(Dispatchers.Main).launch {
                         delay(100)
                         navController.navigate(Route.HomeScreen.route) {
                             popUpTo(Route.SearchScreen.route) { inclusive = true }
                         }
                    }

                 }
            )
        }
    }
}