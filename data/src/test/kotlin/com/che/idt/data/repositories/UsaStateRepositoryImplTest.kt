package com.che.idt.data.repositories

import com.che.idt.data.Success
import com.che.idt.data.model.UsaStateRemoteData
import com.che.idt.data.remote.RemoteDatasource
import com.che.idt.domain.model.UsaState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertContentEquals

internal class UsaStateRepositoryImplTest {

    private val remoteDatasource = mockk<RemoteDatasource>()
    private val testSubject = UsaStateRepositoryImpl(remoteDatasource)

    @Test
    fun `when the result is success should return a list`() = runTest {
        coEvery { remoteDatasource.getUsaStates() } returns Success(UsaStateRemoteData(emptyList()))
        val result = testSubject.getUsaStates()
        assertContentEquals(emptyList<UsaState>(), result)
    }
}
