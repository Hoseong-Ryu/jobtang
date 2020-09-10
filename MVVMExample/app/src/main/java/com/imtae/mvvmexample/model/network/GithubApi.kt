package com.imtae.mvvmexample.model.network

import com.imtae.mvvmexample.model.domain.Contributor
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("repos/{owner}/{repo}/contributors")
    fun getContributors(@Path("owner") owner: String, @Path("repo") repo: String) : Single<List<Contributor>>
}