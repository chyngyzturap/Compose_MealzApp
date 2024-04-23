package com.pharos.composemealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberAsyncImagePainter
import com.pharos.composemealzapp.model.response.MealsCategoriesResponse.MealsResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(
    meal: MealsResponse?
) {
    val scrollState = rememberLazyListState()
    val offset = min(
        1f,
        1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
    )
    val size by animateDpAsState(targetValue = max(100.dp, 140.dp * offset), label = "")

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Surface(
                shadowElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        shape = CircleShape,
                        modifier = Modifier.padding(16.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green

                        )
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = meal?.imageUrl),
                            contentDescription = "detail pic",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(size)
                        )
                    }

                    Text(
                        text = meal?.name ?: "default",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }

            }
            val dummyContentList = (0..100).map { it.toString() }
            LazyColumn(state = scrollState) {
                items(dummyContentList) { dummyItem ->
                    Text(
                        text = dummyItem,
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun DetailsPreview() {
    MealDetailsScreen(MealsResponse("1", "", "", ""))
}