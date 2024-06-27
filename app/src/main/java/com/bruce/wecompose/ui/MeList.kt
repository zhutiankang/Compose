package com.bruce.wecompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bruce.wecompose.R
import com.bruce.wecompose.data.User
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * MeList
 *
 * @author tiankang
 * @description:
 * @date :2024-06-27 15:05
 */

@Composable
fun MeListTopBar() {
    Row(
        Modifier
            .background(WeComposeTheme.colors.listItem)
            .fillMaxWidth()
            .height(224.dp)
    ) {
        Image(
            painterResource(id = R.drawable.avatar_rengwuxian), contentDescription = "Me",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(6.dp))
                .size(64.dp)
        )
        Column(
            Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                User.Me.name,
                Modifier.padding(top = 64.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = WeComposeTheme.colors.textPrimary
            )
            Text(
                "微信号：${User.Me.id}",
                Modifier.padding(top = 16.dp),
                fontSize = 14.sp,
                color = WeComposeTheme.colors.textSecondary
            )
            Text(
                "+ 状态",
                Modifier
                    .padding(top = 16.dp)
                    .border(1.dp, WeComposeTheme.colors.onBackground, RoundedCornerShape(50))
                    .padding(8.dp, 2.dp),
                fontSize = 16.sp,
                color = WeComposeTheme.colors.onBackground
            )
        }
        Icon(
            painterResource(id = R.drawable.ic_qrcode), contentDescription = "qrcode",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 20.dp)
                .size(14.dp),
            tint = WeComposeTheme.colors.onBackground
        )
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)
                .size(16.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}
@Preview(showBackground = true)
@Composable
fun MeListTopBarPreview() {
    MeListTopBar()
}

@Composable
fun MeList(){
    
    Box(
        Modifier
            .background(WeComposeTheme.colors.background)
            .fillMaxSize()) {
        Column(
            Modifier
                .background(WeComposeTheme.colors.listItem)
                .fillMaxWidth()) {
            MeListTopBar()
            Spacer(modifier = Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxWidth()
                .height(8.dp))
            DiscoveryListItem(icon = R.drawable.ic_pay, title = "支付")
            Spacer(modifier = Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxWidth()
                .height(8.dp))
            DiscoveryListItem(R.drawable.ic_collections, "收藏")
            HorizontalDivider(
                Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                thickness = 0.8f.dp,
                color = WeComposeTheme.colors.chatListDivider
            )
            DiscoveryListItem(R.drawable.ic_photos, "朋友圈")
            HorizontalDivider(
                Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                thickness = 0.8f.dp,
                color = WeComposeTheme.colors.chatListDivider
            )
            DiscoveryListItem(R.drawable.ic_cards, "卡包")
            HorizontalDivider(
                Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                thickness = 0.8f.dp,
                color = WeComposeTheme.colors.chatListDivider
            )
            DiscoveryListItem(R.drawable.ic_stickers, "表情")
            Spacer(
                Modifier
                    .background(WeComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            DiscoveryListItem(R.drawable.ic_settings, "设置")
        }
        
    }
}
@Preview(showBackground = true)
@Composable
fun MeListPreview() {
    WeComposeTheme {
        MeList()
    }
}