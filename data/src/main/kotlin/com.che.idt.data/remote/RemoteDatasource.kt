@file:Suppress("MagicNumber")
package com.che.idt.data.remote

import com.che.idt.data.Result
import com.che.idt.data.Success
import com.che.idt.data.model.UsaStateRemoteData
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RemoteDatasource @Inject constructor() {

    suspend fun getUsaStates(): Result<UsaStateRemoteData, Throwable> {
        // Simulate server time lag
        delay(1500)
        return Success(Json.decodeFromString<UsaStateRemoteData>(FAKE_RESPONSE))
    }
}
