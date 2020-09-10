package com.imtae.mvvmexample.di.modules

import com.imtae.mvvmexample.model.network.GithubApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(GithubApi::class.java) }
}