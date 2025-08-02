package com.maruchin.tidyapp.presentation.util

import com.maruchin.tidyapp.data.model.Recurrence
import com.maruchin.tidyapp.data.model.TimeOfDay
import kotlinx.datetime.DayOfWeek

fun Recurrence.format(): String {
    return when (this) {
        is Recurrence.Daily -> {
            val times = timesOfDay.mapNotNull { timeOfDayNamesPl[it] }.joinToString(", ")
            "Codziennie $times"
        }

        is Recurrence.Weekly -> {
            val days = daysOfWeek.mapNotNull { dayOfWeekNamesPl[it] }.joinToString(", ")
            "Co tydzień w $days"
        }

        is Recurrence.Monthly -> "${daysOfMoth.joinToString(", ")} dzień miesiąca"
    }
}

private val timeOfDayNamesPl = mapOf(
    TimeOfDay.MORNING to "rano",
    TimeOfDay.AFTERNOON to "po południu",
    TimeOfDay.EVENING to "wieczorem"
)

private val dayOfWeekNamesPl = mapOf(
    DayOfWeek.MONDAY to "poniedziałek",
    DayOfWeek.TUESDAY to "wtorek",
    DayOfWeek.WEDNESDAY to "środę",
    DayOfWeek.THURSDAY to "czwartek",
    DayOfWeek.FRIDAY to "piątek",
    DayOfWeek.SATURDAY to "sobotę",
    DayOfWeek.SUNDAY to "niedzielę"
)
