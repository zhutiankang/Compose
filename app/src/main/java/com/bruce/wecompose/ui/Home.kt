package com.bruce.wecompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.MainViewModel
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * Home
 *
 * @author tiankang
 * @description:
 * @date :2024-06-17 15:24
 */

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Home(viewModel: MainViewModel) {
    Column {
        HorizontalPager(state = object : PagerState(viewModel.selectedTab) {
            override val pageCount: Int
                get() = 4
        }, Modifier.weight(1f)) { pager ->
            when (pager) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }

        }

        WeBottomBar(selected = viewModel.selectedTab) {
            viewModel.selectedTab = it
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    val viewModel: MainViewModel = viewModel()
    WeComposeTheme(viewModel.theme) {
        Box {
            Home(viewModel)
            ChatPage()
        }
    }
}