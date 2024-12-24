package com.example.ucp2pam_079

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2pam_079.data.database.AppDatabase
import com.example.ucp2pam_079.fragment.DokterPage
import com.example.ucp2pam_079.fragment.JadwalScreen
import com.example.ucp2pam_079.ui.theme.UCP2PAM079Theme
import com.example.ucp2pam_079.viewModel.DokterViewModel
import com.example.ucp2pam_079.viewModel.JadwalViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UCP2PAM079Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController() // Remember the NavController

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Room Database App") }
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationComponent(navController = navController)
            }
        }
    )
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val database = AppDatabase.getDatabase(context)

    val dokterRepository = DokterRepository(database.dokterDao())
    val jadwalRepository = JadwalRepository(database.jadwalDao())

    val dokterViewModel: DokterViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = DokterViewModelFactory(dokterRepository)
    )
    val jadwalViewModel: JadwalViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = JadwalViewModelFactory(jadwalRepository)
    )

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToDokter = { navController.navigate("dokter") },
                onNavigateToJadwal = { navController.navigate("jadwal") }
            )
        }
        composable("dokter") {
            DokterPage(viewModel = dokterViewModel)
        }
        composable("jadwal") {
            JadwalScreen(viewModel = jadwalViewModel)
        }
    }
}



@Composable
fun HomeScreen(onNavigateToDokter: () -> Unit, onNavigateToJadwal: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onNavigateToDokter, modifier = Modifier.padding(8.dp)) {
            Text("Go to Dokter")
        }
        Button(onClick = onNavigateToJadwal, modifier = Modifier.padding(8.dp)) {
            Text("Go to Jadwal")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UCP2PAM079Theme {
        MainScreen()
    }
}
