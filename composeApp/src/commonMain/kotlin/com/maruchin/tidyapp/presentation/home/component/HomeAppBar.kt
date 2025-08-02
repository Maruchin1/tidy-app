package com.maruchin.tidyapp.presentation.home.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.maruchin.tidyapp.presentation.util.formatStandard
import com.maruchin.tidyapp.presentation.util.toLocalDate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeAppBar(
    datePickerState: DatePickerState,
    topAppBarScrollBehavior: TopAppBarScrollBehavior,
) {
    var isSelectingDate by rememberSaveable { mutableStateOf(false) }

    LargeFlexibleTopAppBar(
        title = {
            Text(text = "Witaj Maruchin")
        },
        subtitle = {
            Text(text = "Lorem ipsum dolor sit amet")
        },
        navigationIcon = {

        },
        actions = {
            FilledTonalButton(
                onClick = { isSelectingDate = true },
                contentPadding = ButtonDefaults.ExtraSmallContentPadding,
                shape = ButtonDefaults.squareShape,
                modifier = Modifier.heightIn(ButtonDefaults.ExtraSmallContainerHeight)
            ) {
                Icon(
                    imageVector = Icons.Rounded.CalendarToday,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.ExtraSmallIconSize)
                )
                Spacer(modifier = Modifier.width(ButtonDefaults.ExtraSmallIconSpacing))
                Text(
                    text = datePickerState.selectedDateMillis!!.toLocalDate().formatStandard()
                )
            }
        },
        scrollBehavior = topAppBarScrollBehavior,
    )

    if (isSelectingDate) {
        DatePickerDialog(
            onDismissRequest = { isSelectingDate = false },
            confirmButton = {
                TextButton(onClick = { isSelectingDate = false }) {
                    Text(text = "Zamknij")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}