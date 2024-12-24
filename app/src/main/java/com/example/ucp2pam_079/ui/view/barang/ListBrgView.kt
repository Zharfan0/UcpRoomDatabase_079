package com.example.ucp2pam_079.ui.view.barang

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam_079.data.entity.Barang
import com.example.ucp2pam_079.viewModel.ListBrgUIstate
import com.example.ucp2pam_079.viewModel.ListBrgViewModel
import com.example.ucp2pam_079.viewModel.PenydiaVM
import kotlinx.coroutines.launch

@Composable
fun ListBrgView(
    onBack: () ->Unit,
    viewModel: ListBrgViewModel = viewModel(factory = PenydiaVM.Factory),
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = { },
){
    Scaffold(
        modifier = modifier,
        topBar = {
            com.example.ucp2pam_079.ui.customWidget.TopAppBar(
                judul = "List Barang",
                showBackButton = true,
                onBack = onBack,
                modifier = modifier
            )
        }
    ) {
            innerPadding ->
        val listBrgUIstate by viewModel.listBrgUiState.collectAsState()

        BodyListBrgView(
            listBrgUIstate = listBrgUIstate,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerPadding)
        )

    }
}



@Composable
fun BodyListBrgView(
    listBrgUIstate: ListBrgUIstate,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    when{
        listBrgUIstate.isLoading ->{
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        listBrgUIstate.isError ->{
            LaunchedEffect(listBrgUIstate.errorMessage) {
                listBrgUIstate.errorMessage?.let { message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message)
                    }
                }
            }
        }
        listBrgUIstate.listBrg.isEmpty() ->{
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Tidak ada data Barang",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        else -> {
            ListBarang(
                listBrg = listBrgUIstate.listBrg,
                onClick = {
                    onClick(it)
                    println(it)
                },
                modifier = modifier
            )
        }
    }
}


@Composable
fun ListBarang(
    listBrg: List<Barang>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
){
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = listBrg,
            itemContent = { brg ->
                CardBrg(
                    brg = brg,
                    onClick = {onClick(brg.idBarang.toString())}
                )
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardBrg(
    brg: Barang,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    val CardColor = when {
        brg.stok == 0 -> Color.Gray
        brg.stok in 1..10 -> Color.Red
        brg.stok > 10 -> Color.Green
        else -> Color.LightGray
    }

    Card (
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(150.dp)
    ) {
        Box(
            modifier = Modifier
                .background(color = CardColor) // Cyan color
                .fillMaxHeight()
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Spacer(modifier = Modifier.padding(4.dp))
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "", modifier = Modifier.size(62.dp))
                Spacer(modifier = Modifier.padding(4.dp))
                Column (
                    modifier = Modifier.padding(8.dp)
                ){
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = brg.nama,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }
                    Spacer(modifier = Modifier.padding(4.dp))
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Filled.Info,
                            contentDescription = "")
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = brg.deskripsi,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(imageVector = Icons.Filled.Person,
                            contentDescription = "")
                        Spacer(modifier = Modifier.padding(4.dp))
                        Text(
                            text = brg.nama_sup,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

    }
}