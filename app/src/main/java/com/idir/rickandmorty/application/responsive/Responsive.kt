package com.idir.rickandmorty.application.responsive

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo

enum class WindowBreakpoint {
    Compact, // phones
    Medium,  // small tablets
    Expanded // tablets/desktops
}

@Composable
fun getWindowBreakpoint(): WindowBreakpoint {
    val windowInfo = LocalWindowInfo.current
    val widthDp = windowInfo.containerSize.width

    return when {
        widthDp < 600f -> WindowBreakpoint.Compact
        widthDp < 840f -> WindowBreakpoint.Medium
        else -> WindowBreakpoint.Expanded
    }
}

