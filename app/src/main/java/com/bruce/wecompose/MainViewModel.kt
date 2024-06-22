package com.bruce.wecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bruce.wecompose.data.Chat
import com.bruce.wecompose.data.Msg
import com.bruce.wecompose.data.User
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * MainViewModel
 *
 * @author tiankang
 * @description:
 * @date :2024-06-07 15:18
 */
class MainViewModel : ViewModel() {
    var chats by mutableStateOf(
        listOf(
            // List<Chat>
            Chat(
                friend = User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                mutableStateListOf(
                    Msg(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "锄禾日当午",
                        "14:20"
                    ),
                    Msg(User.Me, "汗滴禾下土", "14:20"),
                    Msg(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "谁知盘中餐",
                        "14:20"
                    ),
                    Msg(User.Me, "粒粒皆辛苦", "14:20"),
                    Msg(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。",
                        "14:20"
                    ),
                    Msg(User.Me, "双兔傍地走，安能辨我是雄雌？", "14:20"),
                    Msg(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "床前明月光，疑是地上霜。",
                        "14:20"
                    ),
                    Msg(User.Me, "吃饭吧？", "14:20"),
                )
            ),
            Chat(
                friend = User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                mutableStateListOf(
                    Msg(
                        User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                        "哈哈哈",
                        "13:48"
                    ),
                    Msg(User.Me, "哈哈昂", "13:48"),
                    Msg(
                        User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                        "你笑个屁呀",
                        "13:48"
                    ).apply { read = false },
                )
            ),
        )
    )
    var selectedTab by mutableStateOf(0)
    var theme by mutableStateOf(WeComposeTheme.Theme.Light)

    var chat: Chat? by mutableStateOf(null)
    var chatting: Boolean by mutableStateOf(false)

    fun startChat(chat: Chat) {
        this.chat = chat
        this.chatting = true
    }

    fun endChat(): Boolean = if (chatting) {
        this.chatting = false
        true
    } else {
        false
    }
}