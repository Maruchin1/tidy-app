package com.maruchin.tidyapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.maruchin.tidyapp.core.device.DefaultDevice
import com.maruchin.tidyapp.core.device.LocalDevice
import com.maruchin.tidyapp.presentation.home.HomeScreen
import com.maruchin.tidyapp.presentation.theme.TidyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    TidyTheme {
        CompositionLocalProvider(LocalDevice provides DefaultDevice()) {
            HomeScreen(onTaskCompletedChange = { _, _ -> }, onTaskClick = {})
        }
    }
}