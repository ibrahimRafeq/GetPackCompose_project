package com.example.jetpackcompose_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackcompose_project.ui.theme.JetPackCompose_ProjectTheme


//name: ibrahim abd al hady
// idNumber: 120222385
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackCompose_ProjectTheme {

                //name: ibrahim abd al hady
                // idNumber: 120222385
                MainApp()
            }
        }
    }
}

//name: ibrahim abd al hady
// idNumber: 120222385