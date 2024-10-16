package com.che.idt.data.model

import kotlinx.serialization.Serializable

@Serializable
internal data class UsaStateRemote(
    val state: String,
    val population: Int,
    val counties: Int,
    val detail: String
)
