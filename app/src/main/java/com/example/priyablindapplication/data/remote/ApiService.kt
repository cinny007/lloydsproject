package com.example.priyablindapplication.data.remote

import com.example.priyablindapplication.data.remote.ToDoDto
import retrofit2.http.GET

interface ApiService {
    @GET("todos/")
    suspend fun getToDO(): List<ToDoDto>
}