package com.nahuelvalencia.details.data

import com.nahuelvalencia.details.utils.createCharacterDto
import org.junit.Assert.*
import org.junit.Test

class DtoToDomain {

    @Test
    fun characterDtoToDomainTest() {
        val sut = createCharacterDto()

        val characterDomain = sut.toDomain()

        assertEquals( 35422, characterDomain.id)
        assertEquals( "Super hero name", characterDomain.name)
        assertEquals( "Hero description", characterDomain.description)
        assertEquals( "https://www.somedomain.com/landscape_large.jpeg", characterDomain.image)
        assertEquals( 4, characterDomain.interestingNumbers.size)

    }

}
