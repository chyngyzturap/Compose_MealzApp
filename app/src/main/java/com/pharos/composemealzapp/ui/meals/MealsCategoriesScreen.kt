package com.pharos.composemealzapp.ui.meals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.pharos.composemealzapp.model.response.MealsCategoriesResponse
import com.pharos.composemealzapp.ui.theme.ComposeMealzAppTheme

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value
    LazyColumn (
        contentPadding = PaddingValues(16.dp)
    ) {
        items(meals) { meal ->
            MealCategory(mealsResponse = meal)
        }
    }
}

@Composable
fun MealCategory(mealsResponse: MealsCategoriesResponse.MealsResponse){
    Card (
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Row {
            AsyncImage(
                model = mealsResponse.imageUrl, contentDescription = "meal photo",
                modifier = Modifier
                    .size(88.dp)
                    .padding(4.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(
                    text = mealsResponse.name,
                    style = MaterialTheme.typography.headlineSmall
                    )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeMealzAppTheme {
        MealsCategoriesScreen()
    }
}