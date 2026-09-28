package com.example.priyablindapplication.data.repository

import com.example.priyablindapplication.data.remote.ApiService
import com.example.priyablindapplication.domain.todo.model.ToDo
import com.example.priyablindapplication.domain.todo.repository.ToDoRepository
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(private val apiService: ApiService) : ToDoRepository {
    override suspend fun getToDo(): List<ToDo> {
        return apiService.getToDO().map { toDoDto ->
            ToDo(id = toDoDto.id, title = toDoDto.title, completed = toDoDto.completed)
        }
    }
}