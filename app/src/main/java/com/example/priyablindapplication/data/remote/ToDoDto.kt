package com.example.priyablindapplication.data.remote

data class ToDoDto(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
