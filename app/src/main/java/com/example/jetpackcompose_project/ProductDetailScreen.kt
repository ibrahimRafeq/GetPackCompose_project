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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(onBack: () -> Unit = {}, onNavigateToCart: () -> Unit = {}) {
    val primaryRed = Color(0xFFB22222)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Device Laser Hair Removal",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = "Back",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                actions = {
                    // Empty box to balance the navigation icon
                    Box(modifier = Modifier.size(48.dp))
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = 8.dp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .navigationBarsPadding(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    IconButton(
                        onClick = onNavigateToCart,
                        modifier = Modifier
                            .size(56.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add to cart",
                            tint = primaryRed
                        )
                    }
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Buy now", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            // Product Image Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFFFFF5F5))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login), // Placeholder
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentScale = ContentScale.Fit
                )

                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(40.dp)
                        .align(Alignment.TopEnd),
                    shadowElevation = 2.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Gray
                        )
                    }
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$10.00",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color(0xFFE0E0E0),
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text("-", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Text(text = "01", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Surface(
                            shape = CircleShape,
                            color = primaryRed,
                            modifier = Modifier.size(32.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    "+",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Rating & Orders Row
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(0.5.dp, Color.LightGray.copy(alpha = 0.5f)),
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFFFD700),
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = " 4.8", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(text = " | 50 Orders", color = Color.Gray, fontSize = 14.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(Icons.Default.Close, contentDescription = null, tint = Color.Gray)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Description
                DescriptionItem("1. Applicable : 100~240V working voltage, suitable for all the countries in the world.")
                DescriptionItem("2. Painless: Adjustable optimal energy level according to the skin tolerance. Providing the gentle treatment painlessly and easily, without hurting the skin. The LED light clear shows the energy level.")
                DescriptionItem("3. Fast and big treatment area : wavelength >510um, 3 cm spot size not too big or neither too small for any body curve, high efficiency and fast speed that just takes several minutes to remove the overlapping region hair which is difficult for traditional hair removal method.")
            }
        }
        @Composable
        fun CartScreen(onBuyClick: () -> Unit) {
            // ... باقي تصميم الشاشة ...
            Button(
                onClick = onBuyClick, // هنا يتم استدعاء الأكشن عند الضغط
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("شراء الآن")
            }
        }
    }
}

@Composable
fun DescriptionItem(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = Color.DarkGray,
        lineHeight = 22.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {
    ProductDetailScreen()
}
