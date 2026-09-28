package com.example.priyablindapplication.domain.usecase

import com.example.priyablindapplication.domain.todo.model.ToDo
import com.example.priyablindapplication.domain.todo.repository.ToDoRepository
import com.example.priyablindapplication.domain.todo.usecase.ToDoUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ToDoUseCaseTest {
    private lateinit var repository: ToDoRepository
    private lateinit var useCase: ToDoUseCase

    @Before
    fun setUp() {
        repository = mockk()
        useCase = ToDoUseCase(repository)
    }

    @Test
    fun `get to do returns to do list`() = runTest {
        val todos = listOf(ToDo(1, "title", true))

        coEvery {
            repository.getToDo()
        } returns todos

        val result = useCase().single()

        assertEquals(result, listOf(ToDo(1, "title", true)))
    }
}