package ru.alexandrorlov.testhammersystem.use_case

import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.base.Result
import ru.alexandrorlov.testhammersystem.data.Repository
import ru.alexandrorlov.testhammersystem.util.NetworkHelper
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: Repository,
    private val networkHelper: NetworkHelper
) {
    suspend fun execute(): Result<Any> {
        if (networkHelper.isConnect()) {
            try {
                repository.fetchMeals()
            } catch (e: Exception) {
                Result.Error(idMessage = R.string.exception_Exception)
            }
        }
        return repository.getMealUiList()
    }
}