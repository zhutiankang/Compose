package com.bruce.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.ui.WeBottomBar
import com.bruce.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeComposeTheme {
                Column {
                    val viewModel:MainViewModel = viewModel()
                    WeBottomBar(selected = viewModel.selectedTab) {
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }
}



