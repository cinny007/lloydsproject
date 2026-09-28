package com.example.priyablindapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ToDoScreen(viewModel: ToDoViewModel = hiltViewModel()) {
    val toDoUiState by viewModel.toDoUiState.collectAsState()

    when (val state = toDoUiState) {
        is ToDoUiState.Loading -> {
            Text(text = "Loading...")
        }

        is ToDoUiState.Error -> {
            Text(text = state.msg)
        }

        is ToDoUiState.Success -> {
            LazyColumn {
                items(state.todos) { toDo ->
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)) {
                        Text(
                            text = "" + toDo.id,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = toDo.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "" + toDo.completed,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}