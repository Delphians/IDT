package com.che.idt.data.remote

import com.che.idt.data.model.UsaStateRemote
import com.che.idt.domain.model.UsaState

internal fun UsaStateRemote.toUsaState(): UsaState =
    UsaState(state, population, counties, detail)
