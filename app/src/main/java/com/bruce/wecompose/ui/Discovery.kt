package com.bruce.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bruce.wecompose.R
import com.bruce.wecompose.ui.theme.WeComposeTheme

/**
 * Discovery
 *
 * @author tiankang
 * @description:
 * @date :2024-06-27 13:48
 */

@Composable
fun DiscoveryListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            title,
            fontSize = 17.sp,
            color = WeComposeTheme.colors.textPrimary
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = WeComposeTheme.colors.more
        )
    }
}


@Composable
fun DiscoveryList() {
    Column(Modifier.fillMaxSize()) {
        WeTopBar(title = "发现")
        Box(
            Modifier
                .background(WeComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .background(WeComposeTheme.colors.listItem)
                    .fillMaxWidth()
            ) {
                DiscoveryListItem(R.drawable.ic_moments, "朋友圈", badge = {
                    Box(
                        Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50))
                            .size(22.dp)
                            .background(WeComposeTheme.colors.badge)
                    ) {
                        Text(
                            "3",
                            Modifier
                                .align(Alignment.Center),
                            fontSize = 12.sp,
                            color = WeComposeTheme.colors.onBadge
                        )
                    }
                }, endBadge = {
                    Image(
                        painterResource(R.drawable.avatar_gaolaoshi), "avatar", Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, WeComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                })
                Spacer(
                    Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_channels, "视频号", endBadge = {
                    Image(
                        painterResource(R.drawable.avatar_diuwuxian), "avatar", Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, WeComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Text(
                        "赞过", Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
                        fontSize = 14.sp, color = WeComposeTheme.colors.textSecondary
                    )
                })
                Spacer(
                    Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_ilook, "看一看")
                HorizontalDivider(
                    Modifier.padding(56.dp, 0.dp, 0.dp, 0.dp),
                    thickness = 0.8f.dp,
                    color = WeComposeTheme.colors.chatListDivider
                )
                DiscoveryListItem(R.drawable.ic_isearch, "搜一搜")
                Spacer(
                    Modifier
                        .background(WeComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_nearby, "直播和附近")
            }
        }
    }
}

@Preview
@Composable
private fun DiscoveryPreview() {
    WeComposeTheme{
        DiscoveryList()
    }
}