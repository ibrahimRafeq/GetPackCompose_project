package com.example.jetpackcompose_project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToCategories: () -> Unit = {},
    onNavigateToFavorite: () -> Unit = {},
    onNavigateToAccount: () -> Unit = {},
    onNavigateToProductDetail: () -> Unit

) {
    val primaryRed = Color(0xFFB22222)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Cart",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "(4)",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToHome() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToCategories() }
                )
                NavigationBarItem(
                    icon = {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = null, tint = primaryRed)
                    },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToFavorite() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToProductDetail() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = {onNavigateToAccount()}

                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            val cartItems = listOf(
                CartItemData("Device Laser Hair Rem...", "$10.00", R.drawable.login),
                CartItemData("Device Laser Hair Rem...", "$10.00", R.drawable.login),
                CartItemData("Device Laser Hair Rem...", "$10.00", R.drawable.login),
                CartItemData("Device Laser Hair Rem...", "$10.00", R.drawable.login)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(cartItems) { item ->
                    CartItemCard(item)
                }
            }

            // Bottom Summary Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "SubTotal", fontSize = 16.sp, color = Color.Gray)
                    Text(text = "$45.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Buy now", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}

data class CartItemData(val name: String, val price: String, val imageRes: Int)

@Composable
fun CartItemCard(item: CartItemData) {
    val primaryRed = Color(0xFFB22222)
    
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDFDFD)),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(0.5.dp, Color.LightGray.copy(alpha = 0.5f))
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFFFFF5F5))
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentScale = ContentScale.Fit
                )
                
                // Delete button (X)
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .size(28.dp)
                        .background(Color.White, CircleShape)
                        .border(1.dp, Color.Red.copy(alpha = 0.2f), CircleShape)
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Remove",
                        tint = Color.Red,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = item.name,
                    fontSize = 13.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Medium
                )
                
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.price,
                        fontSize = 14.sp,
                        color = primaryRed,
                        fontWeight = FontWeight.Bold
                    )
                    
                    // Quantity Controls
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFE0E0E0),
                            modifier = Modifier.size(24.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("-", fontWeight = FontWeight.Bold)
                            }
                        }
                        Text(text = "01", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Surface(
                            shape = CircleShape,
                            color = primaryRed,
                            modifier = Modifier.size(24.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("+", color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Buy now",
                        fontSize = 13.sp,
                        color = primaryRed,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartPreview() {
    CartScreen(){}
}