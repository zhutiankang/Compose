package com.bruce.wecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * MainViewModel
 *
 * @author tiankang
 * @description:
 * @date :2024-06-07 15:18
 */
class MainViewModel : ViewModel() {
    var selectedTab by mutableStateOf(0)
}