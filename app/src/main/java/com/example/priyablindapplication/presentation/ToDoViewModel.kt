package com.example.priyablindapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.priyablindapplication.domain.todo.usecase.ToDoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(private val toDoUseCase: ToDoUseCase) : ViewModel() {
    private var _toDoUiState = MutableStateFlow<ToDoUiState>(ToDoUiState.Loading)
    var toDoUiState = _toDoUiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                toDoUseCase().collectLatest {
                    _toDoUiState.value = ToDoUiState.Success(it)
                }
            } catch (exception: Exception) {
                _toDoUiState.value = ToDoUiState.Error(exception.message?: "Something went wrong.")
            }
        }
    }
}