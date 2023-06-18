package ru.alexandrorlov.testhammersystem.data.remote

import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.base.BaseRemoteDataSource
import ru.alexandrorlov.testhammersystem.base.Result
import javax.inject.Inject

class DataSource @Inject constructor(
    private val apiService: ApiService
) : BaseRemoteDataSource() {

    suspend fun getResultFromNetwork(): Result<Any> {
        return safeApiCall(
            call = { apiService.getRandomOneMeal() },
            errorMessageId = R.string.exception_Exception
        )
    }

    suspend fun getListResultFromNetwork(): Result<List<Any>> {
        val list = mutableListOf<Any>()
        repeat(10) {
            list.add(getResultFromNetwork())
        }

        return Result.Success(list)
    }
}