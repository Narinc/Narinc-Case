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
class StoryMapperTest : RemoteBaseTest() {

    @InjectMocks
    lateinit var mapper: StoryMapper

    @Test
    fun `map model to entity should return converted object`() =
        dispatcher.runBlockingTest {
            // Arrange (Given)
            val story = FakeRemoteData.provideStoryModel()

            // Act (When)
            val homePageItemEntity = mapper.mapFromModel(story)

            // Assert (Then)
            assertThat(homePageItemEntity, instanceOf(HomePageItemEntity::class.java))
            assertEquals(homePageItemEntity.title, story.name)
            assertEquals(homePageItemEntity.subtitle, story.category)
            assertEquals(homePageItemEntity.image?.small, story.image?.small)
            assertEquals(homePageItemEntity.image?.large, story.image?.large)
            assertEquals(homePageItemEntity.date, story.date)
            assertEquals(homePageItemEntity.content, story.text)
        }
}
