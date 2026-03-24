package com.example.jetpackcompose_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToFavorite: () -> Unit = {},
    onNavigateToAccount: () -> Unit = {}
) {
    val primaryRed = Color(0xFFB22222)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Categories",
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
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToHome() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = null, tint = primaryRed) },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = { Badge(containerColor = primaryRed) { Text("3") } }
                        ) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = null, tint = Color.Gray)
                        }
                    },
                    selected = false,
                    onClick = { onNavigateToCart() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToFavorite() }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToAccount() }
                )
            }
        }
    ) { padding ->
        val categories = listOf(
            CategoryItem("Skin creams", R.drawable.login),
            CategoryItem("Nail products", R.drawable.login),
            CategoryItem("perfume", R.drawable.login),
            CategoryItem("Skin care Tools", R.drawable.login),
            CategoryItem("Makeup", R.drawable.login),
            CategoryItem("Hair care tools", R.drawable.login),
            CategoryItem("Personal care", R.drawable.login),
            CategoryItem("Shampoo", R.drawable.login)
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
            items(categories) { category ->
                CategoryCard(category)
            }
        }
    }
}

data class CategoryItem(val name: String, val imageRes: Int)

@Composable
fun CategoryCard(category: CategoryItem) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            
            // Gradient Overlay for text readability
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
                            startY = 300f
                        )
                    )
            )

            Text(
                text = category.name,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoriesPreview() {
    CategoriesScreen()
}
