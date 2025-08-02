package com.maruchin.tidyapp.core.device

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class DefaultDevice : Device {

    override val now: LocalDateTime
        get() {
            val now = Clock.System.now()
            val timezone = TimeZone.currentSystemDefault()
            return now.toLocalDateTime(timezone)
        }
}
