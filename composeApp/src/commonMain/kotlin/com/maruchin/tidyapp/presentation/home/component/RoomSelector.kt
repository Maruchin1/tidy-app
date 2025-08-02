package com.maruchin.tidyapp.presentation.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.tidyapp.data.model.Room
import com.maruchin.tidyapp.data.model.sampleRoomList
import com.maruchin.tidyapp.presentation.theme.TidyTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RoomSelector(
    rooms: List<Room>,
    currentRoomIndex: Int,
    onRoomChange: (Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        rooms.forEachIndexed { index, room ->
            FilterChip(
                selected = index == currentRoomIndex,
                label = { Text(text = room.name) },
                leadingIcon = { Icon(imageVector = room.icon, contentDescription = null) },
                onClick = {
                    onRoomChange(index)
                },
            )
        }
        AssistChip(
            onClick = {},
            label = { Text(text = "Dodaj") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RoomSelectorPreview() {
    TidyTheme {
        RoomSelector(
            rooms = sampleRoomList,
            currentRoomIndex = 0,
            onRoomChange = {}
        )
    }
}