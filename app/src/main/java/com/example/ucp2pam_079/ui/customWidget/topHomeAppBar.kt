package com.example.ucp2pam_079.ui.customWidget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopHomeAppBar() {
    Card(
        shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF42A5F5), Color(0xFF1E88E5))
                    )
                )
                .fillMaxSize()
        ) {
            // Floating Circle Decoration
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(Color(0x80FFFFFF), Color.Transparent),
                            radius = 120f
                        )
                    )
                    .align(Alignment.TopEnd)
                    .offset(x = (-30).dp, y = (-30).dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Menu Icon
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0x40000000))
                        .padding(8.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Inventaris",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                    Text(
                        text = "Toko Jarpeng",
                        color = Color.White.copy(alpha = 0.8f),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }

            // Small tagline or subtitle at the bottom
            Text(
                text = "Kelola barang dengan mudah dan cepat",
                color = Color.White.copy(alpha = 0.7f),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }
    }
}
