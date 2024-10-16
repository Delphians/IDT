package com.che.idt

import com.che.idt.domain.model.UsaState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class MainScreenState(
    val isLoading: Boolean = false,
    val errorMessage: Boolean = false,
    val usaSatesFullList: PersistentList<UsaState> = persistentListOf(),
    val usaStateFilteredList: PersistentList<UsaState> = persistentListOf(),
    val usaState: UsaState? = null,
)
