package com.maruchin.tidyapp.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EventAvailable
import androidx.compose.material.icons.rounded.Forward
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.maruchin.tidyapp.data.model.Task
import com.maruchin.tidyapp.data.model.sampleRoomBedroom
import com.maruchin.tidyapp.presentation.theme.TidyTheme
import com.maruchin.tidyapp.presentation.util.format
import kotlinx.datetime.LocalDate
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun TaskItem(
    date: LocalDate,
    task: Task,
    onCompleteChange: (Boolean) -> Unit,
    onClick: () -> Unit
) {
    val isCompleted = remember(date, task) {
        task.isCompleted(date)
    }
    val isForToday = remember(date, task) {
        task.isPlannedForDay(date)
    }

    Card(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = task.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            textDecoration = TextDecoration.LineThrough.takeIf { isCompleted }
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = task.recurrence.format(),
                        style = MaterialTheme.typography.bodySmall.copy(
                            textDecoration = TextDecoration.LineThrough.takeIf { isCompleted }
                        )
                    )
                }
                if (isForToday) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Checkbox(
                        checked = isCompleted,
                        onCheckedChange = onCompleteChange
                    )
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
            InfoRow(
                icon = Icons.Rounded.EventAvailable,
                label = "Ostatnio wykonano:",
                value = "12 grudnia 2023"
            )
            if (!isForToday) {
                Spacer(modifier = Modifier.height(12.dp))
                InfoRow(
                    icon = Icons.Rounded.Forward,
                    label = "Zaplanowano na:",
                    value = "12 grudnia 2023"
                )
            }
        }
    }
}

@Composable
private fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Preview
@Composable
private fun TaskItemPreview_ForToday() {
    TidyTheme {
        TaskItem(
            date = LocalDate(2025, 8, 2),
            task = sampleRoomBedroom.tasks[0],
            onClick = {},
            onCompleteChange = {}
        )
    }
}

@Preview
@Composable
private fun TaskItemPreview_ForToday_Completed() {
    TidyTheme {
        TaskItem(
            date = LocalDate(2025, 8, 2),
            task = sampleRoomBedroom.tasks[0].complete(LocalDate(2023, 12, 12)),
            onClick = {},
            onCompleteChange = {}
        )
    }
}

@Preview
@Composable
private fun TaskItemPreview_NotForToday() {
    TidyTheme {
        TaskItem(
            date = LocalDate(2025, 8, 2),
            task = sampleRoomBedroom.tasks[1],
            onClick = {},
            onCompleteChange = {}
        )
    }
}
