package com.bruce.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bruce.wecompose.R
import com.bruce.wecompose.data.User
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * Contacts
 *
 * @author tiankang
 * @description:
 * @date :2024-06-27 11:19
 */

@Composable
fun ContactList(contacts: List<User>) {
    Column {
        WeTopBar(title = "通讯录")
        Box(
            modifier = Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            LazyColumn(
                Modifier
                    .background(WeComposeTheme.colors.listItem)
                    .fillMaxWidth()
            ) {
                val buttons = listOf(
                    User("contact_add", "新的朋友", R.drawable.ic_contact_add),
                    User("contact_chat", "仅聊天", R.drawable.ic_contact_chat),
                    User("contact_group", "群聊", R.drawable.ic_contact_group),
                    User("contact_tag", "标签", R.drawable.ic_contact_tag),
                    User("contact_official", "公众号", R.drawable.ic_contact_official),
                )
                itemsIndexed(buttons) { index, contact ->
                    ContactListItem(contact)
                    if (index < buttons.size - 1) {
                        HorizontalDivider(
                            Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                            thickness = 0.8f.dp,
                            color = WeComposeTheme.colors.chatListDivider
                        )
                    }
                }
                item {
                    Text(
                        "朋友",
                        Modifier
                            .background(WeComposeTheme.colors.background)
                            .fillMaxWidth()
                            .padding(12.dp, 8.dp),
                        fontSize = 14.sp,
                        color = WeComposeTheme.colors.onBackground
                    )
                }
                itemsIndexed(contacts) { index, contact ->
                    ContactListItem(contact)
                    if (index < contacts.size - 1) {
                        HorizontalDivider(
                            Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                            thickness = 0.8f.dp,
                            color = WeComposeTheme.colors.chatListDivider
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContactListItem(contact: User) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(contact.avatar), "avatar", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            contact.name,
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
    }
}