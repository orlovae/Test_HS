package ru.alexandrorlov.testhammersystem.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.alexandrorlov.testhammersystem.config.App
import ru.alexandrorlov.testhammersystem.config.DataRemote
import ru.alexandrorlov.testhammersystem.ui.model.Meals

interface ApiService {
    @GET("{api_key}/{random}")
    suspend fun getRandomOneMeal(
        @Path("api_key") api_key: Int = App.THE_MEAL_DB_API_KEY,
        @Path("random") query: String = DataRemote.QUERY_RANDOM
    ): Response<Meals>
}