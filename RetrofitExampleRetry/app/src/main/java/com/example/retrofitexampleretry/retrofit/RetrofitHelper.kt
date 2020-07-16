package com.example.retrofitexampleretry.retrofit

import com.example.retrofitexampleretry.retrofit.network.EmployeeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {

    companion object {

        private val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

        fun getServiceApi() : EmployeeApi {
            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(EmployeeApi::class.java)
        }
    }
}