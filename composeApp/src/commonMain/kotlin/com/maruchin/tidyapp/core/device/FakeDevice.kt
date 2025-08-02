package com.maruchin.tidyapp.core.device

import kotlinx.datetime.LocalDateTime

class FakeDevice : Device {

    override val now: LocalDateTime
        get() = LocalDateTime(2025, 8, 2, 14, 35)
}
