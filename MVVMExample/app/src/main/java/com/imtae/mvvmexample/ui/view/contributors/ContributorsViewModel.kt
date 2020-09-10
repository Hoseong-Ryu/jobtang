package com.imtae.mvvmexample.ui.view.contributors

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imtae.mvvmexample.base.BaseViewModel
import com.imtae.mvvmexample.model.domain.Contributor
import com.imtae.mvvmexample.model.repository.ContributorRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class ContributorsViewModel(private val contributor: ContributorRepository) : BaseViewModel() {

    var contributorList = MutableLiveData<List<Contributor>>()

    fun getContributors() {
        addDisposable(
            contributor.getContributors("JetBrains", "Kotlin")
                .subscribe(
                    {
                        contributorList.postValue(it)
                    },
                    { Log.e("error", it.message.toString()) }
                )
        )
    }
}