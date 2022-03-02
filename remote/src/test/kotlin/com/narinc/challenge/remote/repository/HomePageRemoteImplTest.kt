package com.narinc.challenge.remote.repository

import com.narinc.challenge.remote.api.AppService
import com.narinc.challenge.remote.fakes.FakeRemoteData
import com.narinc.challenge.remote.mappers.MeditationMapper
import com.narinc.challenge.remote.mappers.StoryMapper
import com.narinc.challenge.remote.utils.RemoteBaseTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomePageRemoteImplTest : RemoteBaseTest() {

    @Mock
    lateinit var service: AppService

    @Mock
    lateinit var meditationMapper: MeditationMapper

    @Mock
    lateinit var storyMapper: StoryMapper

    @InjectMocks
    lateinit var remote: HomePageRemoteImpl

    @Test
    fun `get homepage entities should return response with meditation list size 10 from remote server`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            val response = FakeRemoteData.provideHomePageResponse(
                meditationsSize = 10,
                isBannerEnable = false,
                storiesSize = 0
            )
            `when`(service.getData()) doReturn response

            // Act (When)
            remote.getHomePageEntities()

            // Assert (Then)
            verify(meditationMapper, Mockito.times(10)).mapFromModel(any())
        }

    @Test
    fun `get meditations and stories should return error from remote server`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            whenever(service.getData()) doAnswer { throw IOException() }

            // Act (When)
            launch(exceptionHandler) { remote.getHomePageEntities() }

            // Assert (Then)
            assertThat(
                exceptionHandler.uncaughtExceptions.first(),
                CoreMatchers.instanceOf(IOException::class.java)
            )
            verify(service, Mockito.times(1)).getData()
        }
}
