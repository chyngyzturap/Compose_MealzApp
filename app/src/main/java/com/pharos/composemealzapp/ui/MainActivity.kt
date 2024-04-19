package com.pharos.composemealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pharos.composemealzapp.ui.meals.MealsCategoriesScreen
import com.pharos.composemealzapp.ui.theme.ComposeMealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMealzAppTheme {
                MealsCategoriesScreen()
            }
        }
    }
}
