package com.nahuelvalencia.details.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import arrow.core.right
import com.nahuelvalencia.details.domain.usecase.GetCharacterById
import com.nahuelvalencia.details.presentation.components.model.toUI
import com.nahuelvalencia.details.utils.coroutine.MainCoroutineScopeRule
import com.nahuelvalencia.details.utils.createDomainCharacter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelTests {

    @get:Rule
    val mainCoroutineRule = MainCoroutineScopeRule()

    @Test
    fun getEventByIdSuccess() = runTest(mainCoroutineRule.dispatcher) {
        val getCharacterByIdUseCaseMock = mock<GetCharacterById>()
        val character = createDomainCharacter()

        val viewModel = DetailsViewModel(getCharacterById = getCharacterByIdUseCaseMock)

        whenever(getCharacterByIdUseCaseMock(any())).thenReturn(character.right())

        viewModel.state.test {
            viewModel.loadCharacterById(any())

            assertEquals(DetailsUIState.Loading, awaitItem())

            assert(awaitItem() is DetailsUIState.Content)

            expectNoEvents()

            cancelAndConsumeRemainingEvents()
        }
    }

}
