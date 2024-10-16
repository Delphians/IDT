package com.che.idt.data.di

import com.che.idt.data.repositories.UsaStateRepositoryImpl
import com.che.idt.domain.repositories.UsaStateRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    internal abstract fun bindUsaStateRepository(
        usaStateRepositoryImpl: UsaStateRepositoryImpl
    ): UsaStateRepository
}
