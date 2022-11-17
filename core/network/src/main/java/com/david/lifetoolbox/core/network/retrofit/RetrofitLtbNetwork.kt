package com.david.lifetoolbox.core.network.retrofit

import com.david.lifetoolbox.core.network.BuildConfig
import com.david.lifetoolbox.core.network.LtbNetworkDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Retrofit API declaration for LTB Network API
 */
private interface RetrofitLtbNetworkApi {}

private const val LtbBaseUrl = BuildConfig.BACKEND_URL

/**
 * Wrapper for data provided from the [LtbBaseUrl]
 */
@Serializable
private data class NetworkResponse<T>(
    val data: T
)

/**
 * [Retrofit] backed [LtbNetworkDataSource]
 */
class RetrofitLtbNetwork @Inject constructor(
    networkJson: Json
) : LtbNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl("")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()
        .create(RetrofitLtbNetworkApi::class.java)

}