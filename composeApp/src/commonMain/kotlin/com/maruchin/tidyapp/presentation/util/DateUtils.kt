package com.maruchin.tidyapp.presentation.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

private val monthNames = MonthNames(
    january = "stycznia",
    february = "lutego",
    march = "marca",
    april = "kwietnia",
    may = "maja",
    june = "czerwca",
    july = "lipca",
    august = "sierpnia",
    september = "września",
    october = "października",
    november = "listopada",
    december = "grudnia"
)

fun LocalDate.formatStandard(): String = format(
    LocalDate.Format {
        day(padding = Padding.SPACE)
        char(' ')
        monthName(monthNames)
    }
)

@OptIn(ExperimentalTime::class)
fun Long.toLocalDate(): LocalDate {
    val instant = Instant.fromEpochMilliseconds(this)
    val timezone = TimeZone.currentSystemDefault()
    return instant.toLocalDateTime(timezone).date
}

@OptIn(ExperimentalTime::class)
fun currentMilliseconds(): Long {
    return Clock.System.now().toEpochMilliseconds()
}
