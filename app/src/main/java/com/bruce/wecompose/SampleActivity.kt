package com.bruce.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bruce.wecompose.ui.sample.NetImage
import com.bruce.wecompose.ui.theme.WeComposeTheme

class SampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeComposeTheme {
                NetImage()
            }
        }
    }
}
