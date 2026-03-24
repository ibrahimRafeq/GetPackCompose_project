package com.example.jetpackcompose_project

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToCategories: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToFavorite: () -> Unit = {},
    onNavigateToAccount: () -> Unit = {}
) {
    val primaryRed = Color(0xFFB22222)
    val backgroundColor = Color(0xFFF8F8F8)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Good morning",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Gray)
                    }
                    Box {
                        IconButton(onClick = {}) {
                            Icon(Icons.Outlined.Notifications, contentDescription = "Notifications", tint = Color.Gray)
                        }
                        // Notification dot
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .align(Alignment.TopEnd)
                                .offset(x = (-8).dp, y = 8.dp)
                                .background(Color.Red, CircleShape)
                                .border(1.5.dp, Color.White, CircleShape)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 8.dp
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null, tint = primaryRed) },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Menu, contentDescription = null, tint = Color.Gray) },
                    selected = false,
                    onClick = { onNavigateToCategories() }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(backgroundColor)
                .verticalScroll(rememberScrollState())
        ) {
            // Banner Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFFDE4D0)) // Peach/Orange background
            ) {
                // Banner Image (Mockup)
                Image(
                    painter = painterResource(id = R.drawable.login), // Replace with actual banner image
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    alpha = 0.8f
                )

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "lipsticks set",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "$10",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = primaryRed
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text("Shop Now", color = Color.White, fontSize = 14.sp)
                    }
                }
            }

            // Products Grid
            val products = listOf(
                ProductItem("Device Laser Hair Rem...", "Qmele", "$20", "$18", "70 sold", "%20"),
                ProductItem("Device Laser Hair Rem...", "Qmele", "$15", "$10", "50 sold", "%33"),
                ProductItem("CHERRY DARLING...", "Makeup Sponge", "", "", "", "%50"),
                ProductItem("Makeup Brush Set", "Beauty", "", "", "", "%33")
            )

            // Using a Column with rows to simulate grid inside vertical scroll
            products.chunked(2).forEach { rowProducts ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowProducts.forEach { product ->
                        ProductCard(product, modifier = Modifier.weight(1f))
                    }
                    if (rowProducts.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

data class ProductItem(
    val title: String,
    val brand: String,
    val oldPrice: String,
    val newPrice: String,
    val sold: String,
    val discount: String
)

@Composable
fun ProductCard(product: ProductItem, modifier: Modifier = Modifier) {
    val primaryRed = Color(0xFFB22222)
    
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFFFFF5F5)) // Very light pink background
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login), // Placeholder
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize().padding(16.dp),
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
                            Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color.Gray
                        )
                    }
                }

                // Discount Badge
                Surface(
                    color = Color(0xFFFFEBEE),
                    shape = RoundedCornerShape(bottomEnd = 8.dp),
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    Text(
                        text = product.discount,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        fontSize = 10.sp,
                        color = primaryRed,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = product.title,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = product.brand,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                
                if (product.newPrice.isNotEmpty()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = product.oldPrice,
                                fontSize = 11.sp,
                                color = Color.Gray,
                                textDecoration = TextDecoration.LineThrough
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = product.newPrice,
                                fontSize = 13.sp,
                                color = primaryRed,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Text(
                            text = product.sold,
                            fontSize = 10.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    HomeScreen()
}
