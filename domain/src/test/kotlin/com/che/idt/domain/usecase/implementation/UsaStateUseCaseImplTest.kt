package com.che.idt.domain.usecase.implementation

import com.che.idt.domain.fakes.fakeUsaStatesList
import com.che.idt.domain.repositories.UsaStateRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

internal class UsaStateUseCaseImplTest {

    private val usaStateRepository = mockk<UsaStateRepository>()
    private val testSubject = UsaStateUseCaseImpl(usaStateRepository)

    @Test
    fun `when the result is success should return a list`() = runTest {
        coEvery { usaStateRepository.getUsaStates() } returns fakeUsaStatesList
        val result = testSubject.getUsaStates()
        assertEquals(result.size, fakeUsaStatesList.size)
    }
}
