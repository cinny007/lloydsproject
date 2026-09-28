package com.example.priyablindapplication.domain.todo.usecase

import com.example.priyablindapplication.domain.todo.model.ToDo
import com.example.priyablindapplication.domain.todo.repository.ToDoRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ToDoUseCase @Inject constructor(private val repository: ToDoRepository) {
    suspend operator fun invoke() = flow<List<ToDo>> {
        emit(repository.getToDo())
    }
}