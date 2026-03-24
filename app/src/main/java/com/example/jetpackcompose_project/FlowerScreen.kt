package com.example.jetpackcompose_project

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FlowerScreen() {

    val creamColor = Color(0xFFF5EFE1)
    val darkRed = Color(0xFFB32626)
    val pinkCenter = Color(0xFFF06292)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(creamColor),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(280.dp)
                .background(darkRed, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            FlowerIcon(
                modifier = Modifier.size(120.dp),
                petalColor = creamColor,
                centerColor = pinkCenter
            )
        }
    }
}

@Composable
fun FlowerIcon(
    modifier: Modifier = Modifier,
    petalColor: Color,
    centerColor: Color
) {
    Canvas(modifier = modifier) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val petalWidth = size.width * 0.25f
        val petalHeight = size.height * 0.4f

        for (i in 0..3) {
            rotate(degrees = i * 90f) {
                val path = Path().apply {
                    moveTo(centerX, centerY - 10f)
                    quadraticBezierTo(
                        centerX - petalWidth, centerY - petalHeight / 2,
                        centerX, centerY - petalHeight
                    )
                    quadraticBezierTo(
                        centerX + petalWidth, centerY - petalHeight / 2,
                        centerX, centerY - 10f
                    )
                    close()
                }
                drawPath(path = path, color = petalColor)
            }
        }

        drawCircle(
            color = centerColor,
            radius = 15f,
            center = center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFlowerScreen() {
    FlowerScreen()
}