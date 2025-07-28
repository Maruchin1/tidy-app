package com.maruchin.tidyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform