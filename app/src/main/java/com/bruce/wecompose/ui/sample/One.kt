package com.bruce.wecompose.ui.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter

/**
 * One
 *
 * @author tiankang
 * @description: 第一天演示demo
 * @date :2024-07-04 10:31
 */

@Composable
fun NetImage() {

    Column {

        Image(
            rememberImagePainter(data = "https://cockpit-test-oss.smartlink.com.cn/cockpit/cloud/oss/arch/resource/fbdaacf1307e4c189d0072b4eb6ba7d5.png"),
            contentDescription = "网络图片",
            Modifier.size(200.dp, 200.dp)
        )

        AsyncImage(
            model = "https://cockpit-test-oss.smartlink.com.cn/cockpit/cloud/oss/arch/resource/fbdaacf1307e4c189d0072b4eb6ba7d5.png",
            contentDescription = null,
            Modifier.size(300.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NetImagePreview() {

    NetImage()
}