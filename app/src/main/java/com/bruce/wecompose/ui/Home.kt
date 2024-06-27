package com.bruce.wecompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.MainViewModel
import com.bruce.wecompose.ui.theme.WeComposeTheme
import kotlinx.coroutines.launch

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
        val pagerState = rememberPagerState {
            4
        }
        HorizontalPager(state = pagerState, Modifier.weight(1f)) { pager ->
            when (pager) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }

        }
        val scope = rememberCoroutineScope() // 创建 CoroutineScope
        // 不显示 viewModel.selectedTab，改为 pagerState.currentPage
        WeBottomBar(pagerState.currentPage) { page ->
            // 点击页签后，在协程里翻页
            scope.launch {
                pagerState.animateScrollToPage(page)
            }
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