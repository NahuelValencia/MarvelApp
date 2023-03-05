package com.nahuelvalencia.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nahuelvalencia.home.domain.model.MarvelCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterCard(character: MarvelCharacter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.7f)
            .padding(4.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = character.image,
                contentDescription = "${character.name} poster picture",
                contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.7f))
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                text = character.name,
                textAlign = TextAlign.Center,
                color = Color.White,
                maxLines = 2
            )

        }
    }

}

@Preview
@Composable
private fun PreviewCharacterCard() {
    CharacterCard(
        character = MarvelCharacter(
            id = 1234,
            name = "3-D Man",
            description = "God of thunder",
            image = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
        )
    )
}
