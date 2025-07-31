package com.maruchin.tidyapp.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import tidyapp.composeapp.generated.resources.DMSerifText_Regular
import tidyapp.composeapp.generated.resources.Montserrat_Regular
import tidyapp.composeapp.generated.resources.Res

@Composable
fun tidyTypography(): Typography {
    val bodyFontFamily = FontFamily(Font(Res.font.Montserrat_Regular))
    val displayFontFamily = FontFamily(Font(Res.font.DMSerifText_Regular))
    return with(MaterialTheme.typography) {
        copy(
            displayLarge = displayLarge.copy(fontFamily = displayFontFamily),
            displayMedium = displayMedium.copy(fontFamily = displayFontFamily),
            displaySmall = displaySmall.copy(fontFamily = displayFontFamily),
            headlineLarge = headlineLarge.copy(fontFamily = displayFontFamily),
            headlineMedium = headlineMedium.copy(fontFamily = displayFontFamily),
            headlineSmall = headlineSmall.copy(fontFamily = displayFontFamily),
            titleLarge = titleLarge.copy(fontFamily = displayFontFamily),
            titleMedium = titleMedium.copy(fontFamily = displayFontFamily),
            titleSmall = titleSmall.copy(fontFamily = displayFontFamily),
            bodyLarge = bodyLarge.copy(fontFamily = bodyFontFamily),
            bodyMedium = bodyMedium.copy(fontFamily = bodyFontFamily),
            bodySmall = bodySmall.copy(fontFamily = bodyFontFamily),
            labelLarge = labelLarge.copy(fontFamily = bodyFontFamily),
            labelMedium = labelMedium.copy(fontFamily = bodyFontFamily),
            labelSmall = labelSmall.copy(fontFamily = bodyFontFamily)
        )
    }
}