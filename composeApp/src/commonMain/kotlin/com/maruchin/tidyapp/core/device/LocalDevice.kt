package com.maruchin.tidyapp.core.device

import androidx.compose.runtime.staticCompositionLocalOf

val LocalDevice = staticCompositionLocalOf<Device> { FakeDevice() }
