package com.pharos.composemealzapp.model

import com.pharos.composemealzapp.model.response.MealsCategoriesResponse
import retrofit2.Callback

class MealsRepository(
    private val webService: MealsWebService = MealsWebService()
) {

    private var cachedMeals = listOf<MealsCategoriesResponse.MealsResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealsCategoriesResponse.MealsResponse? {
        return cachedMeals.firstOrNull { it.id == id }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this){
            instance ?: MealsRepository().also { instance = it }
        }
    }
}