package com.bruce.wecompose.data

import androidx.annotation.DrawableRes
import com.bruce.wecompose.R

class User(
  val id: String,
  val name: String,
  @DrawableRes val avatar: Int
) {
  companion object {
    val Me: User = User("zhutiankang", "Bruce-天康", R.drawable.avatar_rengwuxian)
  }
}