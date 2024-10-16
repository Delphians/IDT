package com.che.idt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.che.idt.domain.model.UsaState
import com.che.idt.domain.usecase.UsaStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val usaStateUseCase: UsaStateUseCase
) : ViewModel() {

    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState = _mainScreenState.asStateFlow()

    fun fetchUsaStates() {
        viewModelScope.launch {

            _mainScreenState.update { it.copy(isLoading = true, errorMessage = false) }

            usaStateUseCase.getUsaStates().let { usaStates ->
                _mainScreenState.update {
                    if (usaStates.isNotEmpty()) {
                        it.copy(
                            isLoading = false,
                            usaSatesFullList = usaStates,
                            usaStateFilteredList = usaStates
                        )
                    } else {
                        it.copy(errorMessage = true, isLoading = false)
                    }
                }
            }
        }
    }

    fun onUsersStateErrorClose() {
        _mainScreenState.update { it.copy(errorMessage = false) }
    }

    fun filterUsaStates(filterText: String) {
        viewModelScope.launch {
            usaStateUseCase.filterUsaStates(filterText, _mainScreenState.value.usaSatesFullList)
                .let { list ->
                    _mainScreenState.update {
                        it.copy(
                            usaStateFilteredList = list
                        )
                    }
                }
        }
    }

    fun onUsaStateClick(usaState: UsaState) {
        _mainScreenState.update {
            it.copy(usaState = usaState)
        }
    }

    fun onHighlightStateClick(usaState: UsaState) {
        _mainScreenState.update {
            it.copy(
                usaSatesFullList = it.usaSatesFullList.map { state ->
                    if (state.state == usaState.state) {
                        state.copy(isHighlighted = !state.isHighlighted)
                    } else {
                        state
                    }
                }.toPersistentList(),
                usaStateFilteredList = it.usaStateFilteredList.map { state ->
                    if (state.state == usaState.state) {
                        state.copy(isHighlighted = !state.isHighlighted)
                    } else {
                        state
                    }
                }.toPersistentList()
            )
        }
    }
}
