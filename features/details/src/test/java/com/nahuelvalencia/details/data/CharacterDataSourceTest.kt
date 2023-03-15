package com.nahuelvalencia.details.data

import com.nahuelvalencia.details.data.datasource.CharacterApi
import com.nahuelvalencia.details.data.datasource.CharacterDataSourceImpl
import com.nahuelvalencia.details.utils.apiCallHandler
import com.nahuelvalencia.details.utils.coroutine.MainCoroutineScopeRule
import com.nahuelvalencia.details.utils.getJsonStringFromFile
import com.nahuelvalencia.details.utils.retrofit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterDataSourceTest {

    private val mockWebServer = MockWebServer()

    @get:Rule
    val mainCoroutineScopeRule = MainCoroutineScopeRule()

    private fun createDataSource(): CharacterDataSourceImpl = CharacterDataSourceImpl(
        api = retrofit(mockWebServer.url("/")).create(CharacterApi::class.java),
        apiCallHandler = apiCallHandler(),
        dispatcher = mainCoroutineScopeRule.dispatcher
    )

    @Test
    fun characterDataSourceInvokeTest() = runTest(mainCoroutineScopeRule.dispatcher) {
        val sut = createDataSource()

        mockWebServer.enqueue(
            response = MockResponse()
                .setResponseCode(200)
                .setBody(
                    getJsonStringFromFile(
                        fileName = "characters-by-Id-success.json",
                        classLoader = javaClass.classLoader
                    )
                )
        )

        sut.getCharacterById(213245).fold(
            ifLeft = { fail("Expected a success response but fails with: ${it.error}") },
            ifRight = {
                assertEquals(it.data.results.size, 1)
            }
        )
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}
