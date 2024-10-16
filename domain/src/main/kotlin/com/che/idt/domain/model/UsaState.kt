package com.che.idt.domain.model

data class UsaState(
    val state: String,
    val population: Int,
    val counties: Int,
    val detail: String,
    val isHighlighted: Boolean = false
)
