package com.bruce.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.ui.ChatList
import com.bruce.wecompose.ui.WeBottomBar
import com.bruce.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeComposeTheme {
                Column {
                    val viewModel: MainViewModel = viewModel()
                    HorizontalPager(state = object : PagerState(viewModel.selectedTab) {
                        override val pageCount: Int
                            get() = 4
                    }) { pager ->
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
        }
    }
}




