package com.bruce.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bruce.wecompose.MainViewModel
import com.bruce.wecompose.data.Chat
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * ChatList
 *
 * @author tiankang
 * @description:
 * @date :2024-06-13 11:14
 */
@Composable
fun ChatList(chats: List<Chat>) {

    Box(modifier = Modifier
        .background(WeComposeTheme.colors.background)
        .fillMaxSize()) {
        LazyColumn(Modifier.background(WeComposeTheme.colors.listItem)) {
            items(chats.size) { index ->
                val chat = chats[index]
                Row(Modifier.fillMaxSize()) {
                    Image(
                        painterResource(
                            id = chat.friend.avatar
                        ),
                        contentDescription = chat.friend.name,
                        Modifier
                            .size(48.dp)
                            .padding(4.dp)
                            .unread(!chat.msgs.last().read, WeComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Column(
                        Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            chat.friend.name,
                            fontSize = 17.sp,
                            color = WeComposeTheme.colors.textPrimary
                        )
                        Text(
                            chat.msgs.last().text,
                            fontSize = 14.sp,
                            color = WeComposeTheme.colors.textSecondary
                        )
                    }
                    Text(
                        text = chat.msgs.last().time,
                        Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
                        fontSize = 11.sp,
                        color = WeComposeTheme.colors.textSecondary
                    )
                }
                if (index < chats.lastIndex) {
                    HorizontalDivider(
                        Modifier.padding(68.dp, 0.dp, 0.dp, 0.dp),
                        thickness = 0.8f.dp,
                        color = WeComposeTheme.colors.chatListDivider
                    )
                }
            }
        }
    }
}

fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(color, 5.dp.toPx(), Offset(size.width - 1.dp.toPx(), 1.dp.toPx()))
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListPreview() {
    val viewModel: MainViewModel = viewModel()
    ChatList(chats = viewModel.chats)
}
