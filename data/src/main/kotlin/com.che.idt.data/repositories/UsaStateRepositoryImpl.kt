package com.che.idt.data.repositories

import com.che.idt.data.mapBoth
import com.che.idt.data.remote.RemoteDatasource
import com.che.idt.data.remote.toUsaState
import com.che.idt.domain.model.UsaState
import com.che.idt.domain.repositories.UsaStateRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class UsaStateRepositoryImpl @Inject constructor(
    private val remoteDatasource: RemoteDatasource
) : UsaStateRepository {

    override suspend fun getUsaStates(): List<UsaState>? =
        remoteDatasource.getUsaStates().mapBoth(
            success = { result ->
                result.data.map {
                    it.toUsaState()
                }
            },
            failure = {
                null
            }
        )
}
