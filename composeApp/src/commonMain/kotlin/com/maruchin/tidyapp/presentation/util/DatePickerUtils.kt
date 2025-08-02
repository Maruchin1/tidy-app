package com.maruchin.tidyapp.presentation.util

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
val DatePickerState.selectedDate: LocalDate?
    get() = selectedDateMillis?.toLocalDate()
