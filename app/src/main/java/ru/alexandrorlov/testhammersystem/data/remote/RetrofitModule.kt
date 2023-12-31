package ru.alexandrorlov.testhammersystem.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import ru.alexandrorlov.testhammersystem.config.DataRemote

object RetrofitModule {
    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    private val loggingInterceptor = HttpLoggingInterceptor { message ->
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addNetworkInterceptor(loggingInterceptor)
        .build()

    init {

    }

    @OptIn(ExperimentalSerializationApi::class)
    @Suppress("EXPERIMENTAL_API_USAGE")
    fun instance(): Retrofit = Retrofit.Builder()
        .baseUrl(
            DataRemote.getBaseURLGet()
        )
        .addConverterFactory(json.asConverterFactory(contentType))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(httpClient)
        .build()
}