package com.narinc.challenge.remote.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineExceptionHandler
import org.junit.Rule

@ExperimentalCoroutinesApi
open class RemoteBaseTest {

    /**
     * A test rule to allow testing coroutines that use the main dispatcher
     */
    @get:Rule
    val testRule = CoroutineTestRule()

    val dispatcher = testRule.dispatcher
    val exceptionHandler = TestCoroutineExceptionHandler()
}
