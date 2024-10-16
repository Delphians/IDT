package com.che.idt.data.remote

import com.che.idt.data.Failure
import com.che.idt.data.Success
import com.che.idt.data.model.UsaStateRemote
import com.che.idt.data.model.UsaStateRemoteData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

internal class RemoteDatasourceTest {

    private val testSubjectMock = mockk<RemoteDatasource>()
    private val testSubjectReal = RemoteDatasource()

    @Test
    fun `when get an exception from the server should return Failure`() = runTest {
        coEvery { testSubjectMock.getUsaStates() } returns Failure(Throwable())
        val result = testSubjectMock.getUsaStates()
        assert(Failure::class.java == result::class.java)
    }

    @Test
    fun `when get the data from the server should return Success`() = runTest {
        val result = testSubjectReal.getUsaStates()
        assert(Success::class.java == result::class.java)
    }

    @Test
    fun `when get the empty data from the server should return an empty list`() = runTest {
        coEvery { testSubjectMock.getUsaStates() } returns Success(UsaStateRemoteData(emptyList()))
        val result = testSubjectMock.getUsaStates()
        assert(emptyList<UsaStateRemote>() == result.component1()?.data)
    }
}
