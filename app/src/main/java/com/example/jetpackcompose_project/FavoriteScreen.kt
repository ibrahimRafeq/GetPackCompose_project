package com.example.jetpackcompose_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToCategories: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToAccount: () -> Unit = {}
) {
    val primaryRed = Color(0xFFB22222)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Favorite",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
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
                NavigationBarItem(icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToHome() }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                    selected = false,
                    onClick = { onNavigateToCategories() }
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = { Badge(containerColor = primaryRed) { Text("3") } }
                        ) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        }
                    },
                    selected = false,
                    onClick = { onNavigateToCart() }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = null,
                            tint = primaryRed
                        )
                    },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    },
                    selected = false,
                    onClick = {onNavigateToAccount()}
                )
            }
        }
    ) { padding ->
        val favoriteItems = listOf(
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            ),
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            ),
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            ),
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            ),
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            ),
            FavoriteItemData(
                "Device Laser Hair Rem...",
                "Qmele",
                "$10.00",
                "50 sold",
                R.drawable.login
            )
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF8F8F8))
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(favoriteItems) { item ->
                FavoriteItemCard(item)
            }
        }
    }
}

data class FavoriteItemData(
    val title: String,
    val brand: String,
    val price: String,
    val sold: String,
    val imageRes: Int
)

@Composable
fun FavoriteItemCard(item: FavoriteItemData) {
    val primaryRed = Color(0xFFB22222)

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
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

                // Favorite Button
                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp)
                        .align(Alignment.TopEnd),
                    shadowElevation = 2.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = primaryRed
                        )
                    }
                }
            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = item.title,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = item.brand,
                    fontSize = 12.sp,
                    color = Color.Gray
                )

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
                    Text(
                        text = item.sold,
                        fontSize = 10.sp,
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePreview() {
    FavoriteScreen()
}
