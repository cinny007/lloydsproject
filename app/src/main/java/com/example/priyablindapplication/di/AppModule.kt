package com.example.priyablindapplication.di

import com.example.priyablindapplication.data.repository.ToDoRepositoryImpl
import com.example.priyablindapplication.domain.todo.repository.ToDoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun getRepositoryImpl(repositoryImpl: ToDoRepositoryImpl) : ToDoRepository
}