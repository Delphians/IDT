package com.che.idt.domain.di

import com.che.idt.domain.usecase.UsaStateUseCase
import com.che.idt.domain.usecase.implementation.UsaStateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    internal abstract fun bindsGetUsaStateUseCase(
        getUsaStateUseCaseImpl: UsaStateUseCaseImpl
    ): UsaStateUseCase
}
