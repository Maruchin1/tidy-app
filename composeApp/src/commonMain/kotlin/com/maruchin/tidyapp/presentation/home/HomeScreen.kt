package com.maruchin.tidyapp.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maruchin.tidyapp.data.model.Task
import com.maruchin.tidyapp.data.model.sampleRoomList
import com.maruchin.tidyapp.presentation.home.component.HomeAppBar
import com.maruchin.tidyapp.presentation.home.component.RoomSelector
import com.maruchin.tidyapp.presentation.home.component.TaskList
import com.maruchin.tidyapp.presentation.theme.TidyTheme
import com.maruchin.tidyapp.presentation.util.currentMilliseconds
import com.maruchin.tidyapp.presentation.util.selectedDate
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.ExperimentalTime

@OptIn(
    ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class,
    ExperimentalTime::class
)
@Composable
fun HomeScreen(onTaskCompletedChange: (Task, Boolean) -> Unit, onTaskClick: (Task) -> Unit) {
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val pagerState = rememberPagerState { sampleRoomList.size }
    val scope = rememberCoroutineScope()
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = currentMilliseconds()
    )

    Scaffold(
        topBar = {
            HomeAppBar(
                datePickerState = datePickerState,
                topAppBarScrollBehavior = topAppBarScrollBehavior,
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                RoomSelector(
                    rooms = sampleRoomList,
                    currentRoomIndex = pagerState.currentPage,
                    onRoomChange = { index ->
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
                HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
                    TaskList(
                        date = datePickerState.selectedDate!!,
                        room = sampleRoomList[page],
                        topAppBarScrollBehavior = topAppBarScrollBehavior,
                        onTaskCompletedChange = onTaskCompletedChange,
                        onTaskClick = onTaskClick,
                    )
                }
            }
        }
    }


}

@Preview
@Composable
fun HomeScreenPreview() {
    TidyTheme {
        HomeScreen(onTaskCompletedChange = { _, _ -> }, onTaskClick = {})
    }
}
