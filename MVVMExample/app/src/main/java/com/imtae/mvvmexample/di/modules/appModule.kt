package com.imtae.mvvmexample.di.modules

import com.imtae.mvvmexample.model.repository.ContributorRepository
import org.koin.dsl.module

val appModule = module {

    single {
        ContributorRepository(get())
    }
}