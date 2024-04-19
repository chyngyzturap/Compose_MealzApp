package com.pharos.composemealzapp.model

import com.pharos.composemealzapp.model.response.MealsCategoriesResponse
import retrofit2.Callback

class MealsRepository(
    private val webService: MealsWebService = MealsWebService()
) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}