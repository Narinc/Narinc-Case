package com.narinc.challenge.domain.interactor

import com.narinc.challenge.domain.fakes.UserFakeData
import com.narinc.challenge.domain.repository.UserRepository
import com.narinc.challenge.domain.utils.DomainBaseTest
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetUserUseCaseTest : DomainBaseTest() {

    @Mock
    lateinit var repository: UserRepository

    @InjectMocks
    lateinit var useCase: GetUserUseCase

    @Test
    fun `get user should return success result with a user`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            whenever(repository.getUser()) doReturn UserFakeData.provideUser(
                username = "Prad Bitt"
            )

            // Act (When)
            val user = useCase(Unit).single()

            // Assert (Then)
            TestCase.assertEquals(user?.username, "Prad Bitt")
        }

    @Test
    fun `get user should return success with no user`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            whenever(repository.getUser()) doReturn UserFakeData.provideUser(
                username = null
            )

            // Act (When)
            val user = useCase(Unit).single()

            // Assert (Then)
            TestCase.assertEquals(user, null)
        }
}
