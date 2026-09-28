package com.example.priyablindapplication.domain.todo.repository

import com.example.priyablindapplication.domain.todo.model.ToDo

interface ToDoRepository {
    suspend fun getToDo(): List<ToDo>
}