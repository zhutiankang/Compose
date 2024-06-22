package com.bruce.wecompose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.MainViewModel
import kotlin.math.roundToInt

/**
 * ChatPage
 *
 * @author tiankang
 * @description:
 * @date :2024-06-17 15:32
 */

@Composable
fun ChatPage() {
    val viewModel: MainViewModel = viewModel()
    val offsetPercentX by animateFloatAsState(if (viewModel.chatting) 0f else 1f, label = "")
    Column(
        Modifier
            .offsetPercent(offsetPercentX)
            .background(Color.Magenta)
            .fillMaxSize()) {

        WeTopBar(title = viewModel.chat?.friend?.name ?: "微信") {
            viewModel.endChat()
        }

    }
}

fun Modifier.offsetPercent(offsetPercentX: Float = 0f, offsetPercentY: Float = 0f) =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.width, placeable.height) {
            val offsetX = (offsetPercentX * placeable.width).roundToInt()
            val offsetY = (offsetPercentY * placeable.height).roundToInt()
            placeable.placeRelative(offsetX, offsetY)
        }
    }