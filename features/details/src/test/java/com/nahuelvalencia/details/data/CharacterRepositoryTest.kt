package com.nahuelvalencia.details.data

import arrow.core.right
import com.nahuelvalencia.details.data.datasource.CharacterDataSource
import com.nahuelvalencia.details.data.repository.CharacterRepositoryImpl
import com.nahuelvalencia.details.utils.coroutine.MainCoroutineScopeRule
import com.nahuelvalencia.details.utils.createDomainCharacter
import com.nahuelvalencia.details.utils.createMarvelResponseDto
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterRepositoryTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineScopeRule()

    @Test
    fun getCharactersByIdSuccess() = runTest(mainCoroutineRule.dispatcher) {
        val dataSource = mock<CharacterDataSource>()
        val marvelResponse = createMarvelResponseDto()
        val character = createDomainCharacter()

        val sut = CharacterRepositoryImpl(dataSource = dataSource)

        whenever(
            dataSource.getCharacterById(any())
        ).thenReturn(marvelResponse.right())

        val result = sut.getCharacterById(any())

        result.fold(
            ifLeft = { fail() },
            ifRight = {
                assertEquals(character, it)
            }
        )

    }

}
