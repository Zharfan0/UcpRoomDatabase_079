package com.example.ucp2pam_079.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2pam_079.ui.customWidget.TopHomeAppBar

@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    onNavigateAddSup: () -> Unit,
    onNavigateAddBrg: () -> Unit,
    onNavigateListSup: () -> Unit,
    onNavigateListBrg: () -> Unit,
){
    Scaffold (
        modifier = modifier,
        topBar ={
            TopHomeAppBar()
        }
    ){ innerPadding ->


        BodyHome(
            modifier = Modifier.padding(innerPadding),
            onBrgListClick ={
                onNavigateListBrg()
            },
            onAddSupClick = {
                onNavigateAddSup()
            },
            onListSupClick = {
                onNavigateListSup()
            },
            onAddBrgClick = {
                onNavigateAddBrg()
            }
        )
    }
}


@Composable
fun BodyHome(
    modifier: Modifier = Modifier,
    onBrgListClick: () -> Unit,
    onAddSupClick: () -> Unit,
    onAddBrgClick: () -> Unit,
    onListSupClick: () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ){
        Row (
        ){
            CardMenu(
                namaMenu = "List Produk",
                onClick = onBrgListClick
            )
            CardMenu(
                namaMenu = "Add Product",
                onClick = onAddBrgClick
            )
        }
        Row(
        ) {
            CardMenu(
                namaMenu = "List Supplier",
                onClick = onListSupClick
            )
            CardMenu(
                namaMenu = "AddSupplier",
                onClick = onAddSupClick
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenu(
    namaMenu: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .width(180.dp)
            .height(230.dp)
            .padding(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF42A5F5)) // Cyan color
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "",
                    tint = Color.White,
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = namaMenu,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}