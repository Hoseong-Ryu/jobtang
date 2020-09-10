package com.imtae.mvvmexample.di.modules

import com.imtae.mvvmexample.ui.view.contributors.ContributorsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fragmentModule = module {
    viewModel {
        ContributorsViewModel(get())
    }
}