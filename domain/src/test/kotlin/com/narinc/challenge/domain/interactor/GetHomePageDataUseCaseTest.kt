package com.narinc.challenge.domain.interactor

import com.narinc.challenge.domain.fakes.HomePageFakeData
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.repository.HomePageRepository
import com.narinc.challenge.domain.utils.DomainBaseTest
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
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
class GetHomePageDataUseCaseTest : DomainBaseTest() {

    @Mock
    lateinit var repository: HomePageRepository

    @InjectMocks
    lateinit var useCase: GetHomePageDataUseCase

    @Test
    fun `get character should return success result with character list`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            whenever(repository.getHomePageData()) doReturn HomePageFakeData.provideHomePageDataList(
                meditationsSize = 10, isBannerEnable = true, storiesSize = 20
            )

            // Act (When)
            val items = useCase(Unit).single()

            // Assert (Then)
            assertEquals(items.size, 3)
            assertEquals(items.find { it.type == HomePageData.Type.MEDITATION }?.items?.size, 10)
            assertEquals(items.find { it.type == HomePageData.Type.CARD } != null, true)
            assertEquals(items.find { it.type == HomePageData.Type.STORY }?.items?.size, 20)
            verify(repository, times(1)).getHomePageData()
        }
}
