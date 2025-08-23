package com.example.mediunhomepage

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform