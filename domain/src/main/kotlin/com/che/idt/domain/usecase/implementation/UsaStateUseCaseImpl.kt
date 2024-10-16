package com.che.idt.domain.usecase.implementation

import com.che.idt.domain.model.UsaState
import com.che.idt.domain.repositories.UsaStateRepository
import com.che.idt.domain.usecase.UsaStateUseCase
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class UsaStateUseCaseImpl @Inject constructor(
    private val usaStateRepository: UsaStateRepository
) : UsaStateUseCase {

    override suspend fun getUsaStates(): PersistentList<UsaState> = withContext(Dispatchers.IO) {
        val result = usaStateRepository.getUsaStates()
        result?.toPersistentList() ?: persistentListOf()
    }

    override suspend fun filterUsaStates(
        filterText: String,
        fullList: PersistentList<UsaState>
    ): PersistentList<UsaState> = withContext(Dispatchers.Default) {
        if (filterText.isEmpty()) {
            fullList
        } else {
            fullList.filter { state ->
                state.state.contains(filterText, true)
            }.toPersistentList()
        }
    }
}
