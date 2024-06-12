package com.bruce.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bruce.wecompose.R
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * WeBottomBar
 *
 * @author tiankang
 * @description:
 * @date :2024-06-07 15:06
 */
@Composable
fun WeBottomBar(selected: Int, onSelectedListener: (Int) -> Unit) {
    Row(Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (selected == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedListener(0) }
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (selected == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedListener(1) }
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "发现",
            if (selected == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedListener(2) }
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (selected == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon,
            Modifier.weight(1f).clickable { onSelectedListener(3) }
        )
    }
}

// 独立组件
@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier = Modifier) {
    Column(
        modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(painterResource(iconId), contentDescription = title, Modifier.size(24.dp), tint = tint)
        Text(title, fontSize = 11.sp, color = tint)
    }
}

// 预览
@Preview(showBackground = true)
@Composable
private fun WeBottomBarPreview() {
    var selectedTab by remember { mutableStateOf(0) }
    WeComposeTheme {
        WeBottomBar(selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeBottomBarDarkPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        var selectedTab by remember { mutableStateOf(0) }
        WeBottomBar(selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeBottomBarNewYearPreview() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        var selectedTab by remember { mutableStateOf(0) }
        WeBottomBar(selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabItemPreview() {
    TabItem(R.drawable.ic_chat_outlined, "聊天", WeComposeTheme.colors.icon)
}