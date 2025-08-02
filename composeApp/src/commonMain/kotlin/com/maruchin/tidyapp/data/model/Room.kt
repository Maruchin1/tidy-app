package com.maruchin.tidyapp.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathtub
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Kitchen
import androidx.compose.material.icons.filled.Weekend
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate

data class Room(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val tasks: List<Task> = emptyList()
) {

    fun getTasksForDay(day: LocalDate): List<Task> {
        return tasks.filter { it.isPlannedForDay(day) }
    }

    fun getTasksNotForDay(day: LocalDate): List<Task> {
        return tasks.filter { !it.isPlannedForDay(day) }
    }
}

val sampleRoomLivingRoom = Room(
    id = "living_room",
    name = "Salon",
    icon = Icons.Default.Weekend,
    tasks = listOf(
        Task(
            id = "1",
            name = "Odkurzyć dywan",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.SATURDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 1),
                LocalDate(2024, 6, 8)
            )
        ),
        Task(
            id = "2",
            name = "Umyć okna",
            recurrence = Recurrence.Monthly(
                daysOfMoth = setOf(1)
            ),
            records = listOf(
                LocalDate(2024, 5, 1),
                LocalDate(2024, 6, 1)
            )
        ),
        Task(
            id = "3",
            name = "Zrobić porządek z książkami",
            recurrence = Recurrence.Monthly(
                daysOfMoth = setOf(15)
            ),
            records = listOf(
                LocalDate(2024, 5, 15),
                LocalDate(2024, 6, 15)
            )
        )
    )
)

val sampleRoomBedroom = Room(
    id = "bedroom",
    name = "Sypialnia",
    icon = Icons.Default.Bed,
    tasks = listOf(
        Task(
            id = "4",
            name = "Zrobić łóżko",
            recurrence = Recurrence.Daily(
                timesOfDay = setOf(TimeOfDay.MORNING)
            ),
            records = listOf(
                LocalDate(2024, 6, 10),
                LocalDate(2024, 6, 11)
            )
        ),
        Task(
            id = "5",
            name = "Umyć lustro",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.SUNDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 2),
                LocalDate(2024, 6, 9)
            )
        ),
        Task(
            id = "6",
            name = "Przewietrzyć pokój",
            recurrence = Recurrence.Daily(
                timesOfDay = setOf(TimeOfDay.EVENING)
            ),
            records = listOf(
                LocalDate(2024, 6, 10),
                LocalDate(2024, 6, 11)
            )
        )
    )
)

val sampleRoomKitchen = Room(
    id = "kitchen",
    name = "Kuchnia",
    icon = Icons.Default.Kitchen,
    tasks = listOf(
        Task(
            id = "7",
            name = "Umyć naczynia",
            recurrence = Recurrence.Daily(
                timesOfDay = setOf(TimeOfDay.AFTERNOON)
            ),
            records = listOf(
                LocalDate(2024, 6, 10),
                LocalDate(2024, 6, 11)
            )
        ),
        Task(
            id = "8",
            name = "Odkurzyć podłogę",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.FRIDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 7),
                LocalDate(2024, 6, 14)
            )
        ),
        Task(
            id = "9",
            name = "Wyczyścić lodówkę",
            recurrence = Recurrence.Monthly(
                daysOfMoth = setOf(1)
            ),
            records = listOf(
                LocalDate(2024, 5, 1),
                LocalDate(2024, 6, 1)
            )
        )
    )
)

val sampleRoomBathroom = Room(
    id = "bathroom",
    name = "Łazienka",
    icon = Icons.Default.Bathtub,
    tasks = listOf(
        Task(
            id = "10",
            name = "Umyć wannę",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.SATURDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 1),
                LocalDate(2024, 6, 8)
            )
        ),
        Task(
            id = "11",
            name = "Wyczyścić toaletę",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.WEDNESDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 5),
                LocalDate(2024, 6, 12)
            )
        ),
        Task(
            id = "12",
            name = "Umyć lustro",
            recurrence = Recurrence.Weekly(
                daysOfWeek = setOf(DayOfWeek.SUNDAY)
            ),
            records = listOf(
                LocalDate(2024, 6, 2),
                LocalDate(2024, 6, 9)
            )
        )
    )
)

val sampleRoomList = listOf(
    sampleRoomLivingRoom,
    sampleRoomBedroom,
    sampleRoomKitchen,
    sampleRoomBathroom
)
