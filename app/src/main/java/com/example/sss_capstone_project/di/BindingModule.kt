package com.example.sss_capstone_project.di

import com.example.sss_capstone_project.data.remote.repository.CounterRepository
import com.example.sss_capstone_project.data.remote.repository.impl.CounterRepositoryImpl
import com.example.sss_capstone_project.service.ScanDialogService
import com.example.sss_capstone_project.service.impl.ScanDialogServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    @Singleton
    abstract fun providesCounterRepository(counterRepositoryImpl: CounterRepositoryImpl): CounterRepository
    @Binds
    @Singleton
    abstract fun providesScanDialogService(scanDialogServiceImpl: ScanDialogServiceImpl): ScanDialogService
}