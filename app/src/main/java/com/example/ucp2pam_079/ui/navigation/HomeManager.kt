package com.example.ucp2pam_079.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2pam_079.ui.view.HomeView
import com.example.ucp2pam_079.viewModel.HomeVM

@Composable
fun HomeManager(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController, startDestination = DestinasiHome.route
    ) {
        composable(
            route = DestinasiHome.route
        ) { HomeView(
            modifier = modifier,
            onNavigateAddSup ={ navController.navigate(DestinasiInsertSup.route) },
            onNavigateListSup = {navController.navigate(DestinasiListSup.route) },
            onNavigateAddBrg = {navController.navigate(DestinasiInsertBrg.route) },
            onNavigateListBrg = {navController.navigate(DestinasiListBrg.route)}
        )
        }
        composable(
            route = DestinasiInsertSup.route
        ) {
            InsertSupView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                },
                modifier = modifier
            )
        }

        composable(
            route = DestinasiListSup.route
        ) {
            ListSupView(
                modifier = modifier,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = DestinasiInsertBrg.route
        ) {
            InsertBrgView(
                modifier = modifier,
                onNavigate = {

                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = DestinasiListBrg.route
        ) {
            ListBrgView(
                modifier = modifier,
                onBack = {
                    navController.popBackStack()
                },
                onDetailClick = {
                        idBarang ->
                    navController.navigate("${DestinasiDetailBrg.route}/$idBarang")
                    println("PengelolaHalaman: idBarang = $idBarang")
                }
            )
        }
        composable(
            DestinasiDetailBrg.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiDetailBrg.IDBRG){
                    type = NavType.StringType
                }
            )
        ) {
            val idbrg = it.arguments?.getString(DestinasiDetailBrg.IDBRG)
            idbrg?.let { idbrg ->
                DetailBrgView(
                    modifier = modifier,
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdateBrg.route}/$idbrg")
                    },
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdateBrg.routesWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdateBrg.IDBRG){
                    type = NavType.IntType
                }
            )
        ) {
            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}