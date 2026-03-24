package com.example.jetpackcompose_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToCategories: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToFavorite: () -> Unit = {},
    onNavigateToProfileEdit: () -> Unit = {}
) {
    val primaryRed = Color(0xFFB22222)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Account",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
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
                    icon = { Icon(Icons.Filled.Person, contentDescription = null, tint = primaryRed) },
                    selected = true,
                    onClick = {},
                    colors = NavigationBarItemDefaults.colors(indicatorColor = Color.Transparent)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Profile Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.login), // Placeholder image
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    // Camera icon
                    Surface(
                        shape = CircleShape,
                        color = Color.Red,
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = 4.dp, y = 4.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Mona Fadl Al-Harthy",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "009665211043",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "Mona Fadl@gmail.com",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                IconButton(onClick = onNavigateToProfileEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Profile", tint = Color.Blue)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(16.dp))

            // Menu Items
            AccountMenuItem(icon = Icons.Default.List, title = "My order", badgeCount = "4")
            AccountMenuItem(icon = Icons.Default.ShoppingCart, title = "payment mathod")
            AccountMenuItem(icon = Icons.Default.LocationOn, title = "shipping address")
            
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(16.dp))

            AccountMenuItem(icon = Icons.Default.Info, title = "FQA")
            AccountMenuItem(icon = Icons.Default.Person, title = "invite friends")
            AccountMenuItem(icon = Icons.Default.Settings, title = "settings")

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(16.dp))

            AccountMenuItem(icon = Icons.Default.ExitToApp, title = "Logout", titleColor = Color.Black)
        }
    }
}

@Composable
fun AccountMenuItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    badgeCount: String? = null,
    titleColor: Color = Color.Black
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 16.sp,
            color = titleColor,
            modifier = Modifier.weight(1f)
        )
        if (badgeCount != null) {
            Text(
                text = badgeCount,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    AccountScreen()
}
