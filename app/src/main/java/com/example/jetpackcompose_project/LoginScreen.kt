package com.example.jetpackcompose_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit = {}) {
    var phone by remember { mutableStateOf("") }
    val backgroundColor = Color(0xFFC7C7B9)
    val primaryRed = Color(0xFFB22222)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    backgroundColor.copy(alpha = 0.5f),
                                    backgroundColor
                                ),
                                startY = 600f
                            )
                        )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Your Phone number",
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "+972",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Box(modifier = Modifier.fillMaxWidth()) {
                        if (phone.isEmpty()) {
                            Text(
                                text = "Enter Your Phone Number",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                        BasicTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Sign in with Email",
                    color = primaryRed,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = { onLoginSuccess() },
                    colors = ButtonDefaults.buttonColors(containerColor = primaryRed),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        text = "login",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                val termsText = buildAnnotatedString {
                    append("By clicking login you agree to our ")
                    withStyle(style = SpanStyle(color = Color(0xFF4285F4))) {
                        append("terms & conditions")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(color = Color(0xFF4285F4))) {
                        append("privacy policy")
                    }
                }

                Text(
                    text = termsText,
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color.LightGray.copy(alpha = 0.5f))
                    Text(
                        text = " OR ",
                        modifier = Modifier.padding(horizontal = 10.dp),
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color.LightGray.copy(alpha = 0.5f))
                }

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    SocialButton("G", Color(0xFFEA4335))
                    SocialButton("f", Color(0xFF1877F2))
                    SocialButton("t", Color(0xFF1DA1F2))
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun SocialButton(text: String, iconColor: Color) {
    Surface(
        shape = CircleShape,
        color = Color.White,
        modifier = Modifier.size(60.dp),
        shadowElevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = iconColor
            )
        }
    }
}
