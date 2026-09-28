package com.example.priyablindapplication.presentation

import com.example.priyablindapplication.domain.todo.model.ToDo

sealed class ToDoUiState {
    data object Loading: ToDoUiState()
    data class Success(val todos: List<ToDo>): ToDoUiState()
    data class Error(val msg: String) : ToDoUiState()
}