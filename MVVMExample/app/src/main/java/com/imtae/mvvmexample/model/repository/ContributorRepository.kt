package com.imtae.mvvmexample.model.repository

import com.imtae.mvvmexample.model.domain.Contributor
import com.imtae.mvvmexample.model.network.GithubApi
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent

class ContributorRepository(private val githubApi: GithubApi) : KoinComponent {

    fun getContributors(owner: String, repo: String): Single<List<Contributor>> {

        return githubApi.getContributors(owner, repo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}