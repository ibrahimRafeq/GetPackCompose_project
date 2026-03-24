package com.example.jetpackcompose_project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileEditScreen(onDismiss: () -> Unit = {}) {
    var name by remember { mutableStateOf("Mona Fadl Al-Harthy") }
    var phone by remember { mutableStateOf("00966 5211043") }
    var email by remember { mutableStateOf("Mona Fadl@gmail.com") }

    val primaryRed = Color(0xFFB22222)
    val fieldBackgroundColor = Color(0xFFF9F9F4)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black.copy(alpha = 0.4f) // Overlay effect if shown as dialog, but user asked for a screen
    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .background(Color.White, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .padding(24.dp)
            ) {
                // Top Handle and Close button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(24.dp))
                    // Small gray handle at the top
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(4.dp)
                            .background(Color.Black, RoundedCornerShape(2.dp))
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.Red)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Name Field
                EditField(label = "Your Name", value = name, onValueChange = { name = it }, backgroundColor = fieldBackgroundColor)
                
                Spacer(modifier = Modifier.height(16.dp))

                // Phone Field
                EditField(label = "Your Phone number", value = phone, onValueChange = { phone = it }, backgroundColor = fieldBackgroundColor)

                Spacer(modifier = Modifier.height(16.dp))

                // Email Field
                EditField(label = "Your Email Addres", value = email, onValueChange = { email = it }, backgroundColor = fieldBackgroundColor)

                Spacer(modifier = Modifier.height(32.dp))

                // Done Button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Done", fontSize = 18.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun EditField(label: String, value: String, onValueChange: (String) -> Unit, backgroundColor: Color) {
    Column {
        Text(text = label, fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                disabledContainerColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true
        )
    }
}

@Preview
@Composable
fun ProfileEditPreview() {
    ProfileEditScreen()
}
