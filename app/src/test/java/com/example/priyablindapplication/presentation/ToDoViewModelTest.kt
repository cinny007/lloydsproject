package com.example.priyablindapplication.presentation

import com.example.priyablindapplication.domain.todo.model.ToDo
import com.example.priyablindapplication.domain.todo.usecase.ToDoUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class ToDoViewModelTest {
    private lateinit var useCase: ToDoUseCase

    @Before
    fun setUp() {
        useCase = mockk()
    }

    @Test
    fun `get todo returns success`() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)

        coEvery {
            useCase()
        } returns flowOf(listOf(ToDo(1, "title", true)) )

        val viewModel = ToDoViewModel(useCase)

        advanceUntilIdle()

        assertEquals(
            ToDoUiState.Success(listOf(ToDo(1, "title", true))),
            viewModel.toDoUiState.value
        )
    }

    @Test
    fun `get todo returns failure`() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)

        coEvery {
            useCase()
        } throws Exception("Something went wrong.")

        val viewModel = ToDoViewModel(useCase)

        advanceUntilIdle()

        assertEquals(ToDoUiState.Error("Something went wrong."), viewModel.toDoUiState.value)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}