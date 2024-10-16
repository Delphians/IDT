package com.che.idt.domain.usecase

import com.che.idt.domain.model.UsaState
import kotlinx.collections.immutable.PersistentList

interface UsaStateUseCase {

    suspend fun getUsaStates(): PersistentList<UsaState>

    suspend fun filterUsaStates(
        filterText: String,
        fullList: PersistentList<UsaState>
    ): PersistentList<UsaState>
}
