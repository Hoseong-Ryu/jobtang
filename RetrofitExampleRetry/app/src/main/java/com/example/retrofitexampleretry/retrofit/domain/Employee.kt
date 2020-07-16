package com.example.retrofitexampleretry.retrofit.domain

import com.google.gson.annotations.SerializedName

data class Employee(
    val status: String,
    val data: ArrayList<Data>
)

data class Data(
    val id: String,
    val employee_name: String,
    val employee_salary: String,
    val employee_age: String,
    @SerializedName("profile_image")
    val image: String
)