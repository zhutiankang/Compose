package com.bruce.wecompose.ui.sample

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * Animation
 *
 * @author tiankang
 * @description: 动画
 * Animatable底层是用Float实现的
 * @date :2024-08-23 10:30
 */

@Composable
fun StateAnimation(size: Dp, onClick: () -> Unit = {}) {
//    var size by remember { mutableStateOf(48.dp) }
//    val size by animateDpAsState(if (big) 96.dp else 48.dp)

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Green)
            .clickable(onClick = onClick)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
private fun StateAnimationPreview() {
    var big by remember {
        mutableStateOf(false)
    }
    //状态转移型动画
    val size by animateDpAsState(if (big) 96.dp else 48.dp)

    val size1 = remember(key1 = big) {
        if (big) 96.dp else 48.dp
    }
    //流程定制型动画
    val anim = remember {
        Animatable(size1, Dp.VectorConverter)
    }
    // key1值变化才会重新执行，常量不变化只会执行一次
    LaunchedEffect(key1 = big) {
//        delay(2000L)
        //无动画变化 瞬间变化
        anim.snapTo(if (big) 196.dp else 0.dp)
        //有动画变化
        anim.animateTo(size1)
        //衰减动画，动画过渡效果
//        anim.animateDecay(size1)
    }
    StateAnimation(anim.value) {
        big = !big
    }
}