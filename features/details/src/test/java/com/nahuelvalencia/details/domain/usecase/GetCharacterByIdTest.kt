package com.nahuelvalencia.details.domain.usecase

import arrow.core.right
import com.nahuelvalencia.details.domain.repository.CharacterRepository
import com.nahuelvalencia.details.utils.createDomainCharacter
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetCharacterByIdTest {

    @Test
    fun getCharacterByIdSuccess() = runTest {
        val repo = mock<CharacterRepository>()
        val character = createDomainCharacter()

        val sut = GetCharacterById(repository = repo)

        whenever(
            repo.getCharacterById(any())
        ).thenReturn(character.right())

        val result = sut.invoke(any())

        result.fold(
            ifLeft = { fail() },
            ifRight = { assertEquals(character, it) }
        )
    }

}