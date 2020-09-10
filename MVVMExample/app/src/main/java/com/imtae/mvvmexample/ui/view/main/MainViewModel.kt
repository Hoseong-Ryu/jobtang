package com.imtae.mvvmexample.ui.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imtae.mvvmexample.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    var buttonClick = MutableLiveData<Unit>()

    fun clickButton() {
        buttonClick.value = Unit
    }
}