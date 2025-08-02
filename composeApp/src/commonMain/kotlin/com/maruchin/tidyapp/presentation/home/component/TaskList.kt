package com.maruchin.tidyapp.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.maruchin.tidyapp.data.model.Room
import com.maruchin.tidyapp.data.model.Task
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TaskList(
    date: LocalDate,
    room: Room,
    topAppBarScrollBehavior: TopAppBarScrollBehavior,
    onTaskCompletedChange: (Task, Boolean) -> Unit,
    onTaskClick: (Task) -> Unit,
) {
    val todayTasks = remember(date, room) {
        room.getTasksForDay(date)
    }
    val otherTasks = remember(room, date) {
        room.getTasksNotForDay(date)
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection)
    ) {
        stickyHeader {
            Text(
                text = "Dzisiejsze",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        items(todayTasks) { task ->
            TaskItem(
                date = date,
                task = task,
                onCompleteChange = { onTaskCompletedChange(task, it) },
                onClick = { onTaskClick(task) }
            )
        }
        stickyHeader {
            Text(
                text = "Pozostałe",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
            )
        }
        items(otherTasks) { task ->
            TaskItem(
                date = date,
                task = task,
                onCompleteChange = { onTaskCompletedChange(task, it) },
                onClick = { onTaskClick(task) }
            )
        }
    }
}