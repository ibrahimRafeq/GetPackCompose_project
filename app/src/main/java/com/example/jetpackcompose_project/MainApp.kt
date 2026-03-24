package com.example.jetpackcompose_project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay


                   //name: ibrahim abd al hady
                   // idNumber: 120222385
@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf("splash") }

    LaunchedEffect(Unit) {
        if (currentScreen == "splash") {
            delay(1500)
            currentScreen = "login"
        }
    }

    when (currentScreen) {
        "splash" -> FlowerScreen()
        "login" -> LoginScreen(onLoginSuccess = { currentScreen = "home" })
        "home" -> HomeScreen(
            onNavigateToCategories = { currentScreen = "categories" },
            onNavigateToCart = { currentScreen = "cart" },
            onNavigateToFavorite = { currentScreen = "favorite" },
            onNavigateToAccount = { currentScreen = "account" }
        )
        "categories" -> CategoriesScreen(
            onNavigateToHome = { currentScreen = "home" },
            onNavigateToCart = { currentScreen = "cart" },
            onNavigateToFavorite = { currentScreen = "favorite" },
            onNavigateToAccount = { currentScreen = "account" }
        )
        "cart" -> CartScreen(
            onNavigateToHome = { currentScreen = "home" },
            onNavigateToCategories = { currentScreen = "categories" },
            onNavigateToFavorite = { currentScreen = "favorite" },
            onNavigateToAccount = { currentScreen = "account" },
            onNavigateToProductDetail = { currentScreen = "product_detail" }
        )
        "favorite" -> FavoriteScreen(
            onNavigateToHome = { currentScreen = "home" },
            onNavigateToCategories = { currentScreen = "categories" },
            onNavigateToCart = { currentScreen = "cart" },
            onNavigateToAccount = { currentScreen = "account" }
        )
        "account" -> AccountScreen(
            onNavigateToHome = { currentScreen = "home" },
            onNavigateToCategories = { currentScreen = "categories" },
            onNavigateToCart = { currentScreen = "cart" },
            onNavigateToFavorite = { currentScreen = "favorite" },
            onNavigateToProfileEdit = { currentScreen = "profile_edit" }
        )
        "profile_edit" -> ProfileEditScreen(
            onDismiss = { currentScreen = "account" }
        )
        "product_detail" -> ProductDetailScreen(
            onBack = { currentScreen = "cart" },
            onNavigateToCart = { currentScreen = "cart" }
        )
    }
}
