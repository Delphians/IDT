package com.che.idt.domain.repositories

import com.che.idt.domain.model.UsaState

interface UsaStateRepository {
    suspend fun getUsaStates(): List<UsaState>?
}
