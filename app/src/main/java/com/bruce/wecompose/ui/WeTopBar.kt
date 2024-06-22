package com.bruce.wecompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.MainViewModel
import com.bruce.wecompose.R
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * WeTopBar
 *
 * @author tiankang
 * @description:
 * @date :2024-06-15 17:27
 */

@Composable
fun WeTopBar(title: String, onBack: (() -> Unit)? = null) {

    Box(
        Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(Modifier.height(48.dp)) {
            if (onBack != null) {
                Icon(
                    painterResource(id = R.drawable.ic_back),
                    contentDescription = "返回",
                    modifier = Modifier
                        .clickable { onBack() }
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = WeComposeTheme.colors.icon
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            val viewModel: MainViewModel = viewModel()
            Icon(
                painterResource(id = R.drawable.ic_palette),
                contentDescription = "切换主题",
                modifier = Modifier
                    .clickable {
                        viewModel.theme = when (viewModel.theme) {
                            WeComposeTheme.Theme.Light -> WeComposeTheme.Theme.Dark
                            WeComposeTheme.Theme.Dark -> WeComposeTheme.Theme.NewYear
                            WeComposeTheme.Theme.NewYear -> WeComposeTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = WeComposeTheme.colors.icon
            )
        }

        Text(
            text = title,
            Modifier.align(Alignment.Center),
            color = WeComposeTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
private fun WeTopBarPreview() {
    WeTopBar(title = "微信")
}