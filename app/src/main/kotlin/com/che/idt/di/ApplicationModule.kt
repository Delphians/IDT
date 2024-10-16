package com.che.idt.di

import com.che.idt.data.di.DataModule
import com.che.idt.domain.di.UseCaseModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DataModule::class,
        UseCaseModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object ApplicationModule
