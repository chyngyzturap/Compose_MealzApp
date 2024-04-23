package com.pharos.composemealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pharos.composemealzapp.model.MealsRepository
import com.pharos.composemealzapp.model.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository.getInstance()
) : ViewModel() {

    val mealsState = mutableStateOf(emptyList<MealsCategoriesResponse.MealsResponse>())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMeals()
        }
    }

    private suspend fun getMeals(): List<MealsCategoriesResponse.MealsResponse> {
        return repository.getMeals().categories
    }
}