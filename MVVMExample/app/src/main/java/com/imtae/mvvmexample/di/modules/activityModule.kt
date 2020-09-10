package com.imtae.mvvmexample.di.modules

import com.imtae.mvvmexample.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val activityModule = module {
    viewModel {
        MainViewModel()
    }
}