package com.deepakjetpackcompose.artestapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.deepakjetpackcompose.artestapp.ui.screens.AlphabetScreen
import com.deepakjetpackcompose.artestapp.ui.screens.ArScreen
import com.deepakjetpackcompose.artestapp.ui.screens.HomeScreen

@Composable
fun NavApp(modifier: Modifier = Modifier) {

    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = NavigationHelper.HOMESCREEN) {
        composable <NavigationHelper.HOMESCREEN>{ HomeScreen(navController = navController, modifier = modifier) }
        composable <NavigationHelper.ARSCREEN>{
            val model=it.toRoute<NavigationHelper.ARSCREEN>().model
            ArScreen( navController = navController, model = model, modifier = modifier)
        }
        composable <NavigationHelper.APLHABETSCREEN>{ AlphabetScreen(navController = navController, modifier = modifier) }

    }

}