package com.example.priyablindapplication.data.repository

import com.example.priyablindapplication.data.remote.ApiService
import com.example.priyablindapplication.data.remote.ToDoDto
import com.example.priyablindapplication.domain.todo.model.ToDo
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ToDoRepositoryImplTest {
    private lateinit var apiService: ApiService
    private lateinit var repository: ToDoRepositoryImpl

    @Before
    fun setUp() {
        apiService = mockk()
        repository = ToDoRepositoryImpl(apiService)
    }

    @Test
    fun `get to do returns to do list`() = runTest {
        val todos = listOf(ToDoDto(1,1,"title",true))

        coEvery {
            apiService.getToDO()
        } returns todos

        val result = repository.getToDo()

        assertEquals(result, listOf(ToDo(1,"title",true)))
    }
}