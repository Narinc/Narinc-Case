package com.narinc.challenge.remote.mappers

import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.remote.fakes.FakeRemoteData
import com.narinc.challenge.remote.utils.RemoteBaseTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MeditationMapperTest : RemoteBaseTest() {

    @InjectMocks
    lateinit var mapper: MeditationMapper

    @Test
    fun `map model to entity should return converted object`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            val meditation = FakeRemoteData.provideMeditationModel()

            // Act (When)
            val homePageItemEntity = mapper.mapFromModel(meditation)

            // Assert (Then)
            assertThat(homePageItemEntity, instanceOf(HomePageItemEntity::class.java))
            assertEquals(homePageItemEntity.title, meditation.title)
            assertEquals(homePageItemEntity.subtitle, meditation.subtitle)
            assertEquals(homePageItemEntity.image?.small, meditation.image?.small)
            assertEquals(homePageItemEntity.image?.large, meditation.image?.large)
            assertEquals(homePageItemEntity.date, meditation.releaseDate)
            assertEquals(homePageItemEntity.content, meditation.content)
        }
}
