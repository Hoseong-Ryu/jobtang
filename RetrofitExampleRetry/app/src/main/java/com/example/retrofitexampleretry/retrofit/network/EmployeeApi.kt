package com.example.retrofitexampleretry.retrofit.network

import com.example.retrofitexampleretry.retrofit.domain.Employee
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface EmployeeApi {

    @GET("employees")
    fun getOkHttpEmployees(): Call<Employee>

    @GET("employees")
    fun getRxEmployees(): Observable<Employee>
}