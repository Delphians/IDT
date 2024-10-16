@file:Suppress("MagicNumber")
package com.che.idt.domain.fakes

import com.che.idt.domain.model.UsaState
import kotlinx.collections.immutable.toPersistentList

val fakeUsaStatesList = List(5) {
    UsaState(
        state = "Alabama $it",
        population = 4833722,
        counties = 67 + it,
        detail = "http:pos.idtretailsolutions.comcountyteststatesAlabama"
    )
}.toPersistentList()
