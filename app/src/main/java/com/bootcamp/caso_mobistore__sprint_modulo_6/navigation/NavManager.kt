package com.bootcamp.caso_mobistore__sprint_modulo_6.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bootcamp.caso_mobistore__sprint_modulo_6.view.DetailsView
import com.bootcamp.caso_mobistore__sprint_modulo_6.view.HomeView
import com.bootcamp.caso_mobistore__sprint_modulo_6.viewModel.ProductViewModel

@Composable
fun NavManager(
    viewModel: ProductViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
            composable("Home"){
                HomeView(viewModel,navController)
            }

            composable("DetailsView/{id}", arguments = listOf(
                navArgument("id"){type = NavType.IntType}
            )){
                val id = it.arguments?.getInt("id") ?: 0
                DetailsView(viewModel,navController,id)
            }
    }

}