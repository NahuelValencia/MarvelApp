package com.nahuelvalencia.details.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.nahuelvalencia.details.presentation.components.model.CharacterUi

@Composable
internal fun CharacterInformation(character: CharacterUi) {
    ConstraintLayout {
        val (image, name, description, extraInfo) = createRefs()

        AsyncImage(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            model = character.image,
            contentDescription = "${character.name} poster picture",
            contentScale = ContentScale.FillWidth
        )

        Text(
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .fillMaxWidth(),
            text = character.name,
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )

        Text(
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(name.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            text = character.description.ifBlank { "No description" }
        )

        ExtraInformation(
            modifier = Modifier
                .constrainAs(extraInfo) {
                    top.linkTo(description.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .wrapContentSize(),
            interestingNumbers = character.interestingNumbers
        )
    }

}

@Composable
private fun ExtraInformation(modifier: Modifier, interestingNumbers: Map<String, Int>) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Appeared in",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            interestingNumbers.keys.forEach { category ->
                InterestingNumber(
                    modifier = Modifier,
                    number = interestingNumbers[category]!!,
                    title = category
                )
            }
        }
    }
}
