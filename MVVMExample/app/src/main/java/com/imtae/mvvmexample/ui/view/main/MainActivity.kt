package com.imtae.mvvmexample.ui.view.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.imtae.mvvmexample.R
import com.imtae.mvvmexample.base.BaseActivity
import com.imtae.mvvmexample.databinding.ActivityMainBinding
import com.imtae.mvvmexample.ui.view.contributors.ContributorsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    override val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.buttonClick.observe(this, Observer {
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content , ContributorsFragment())
                .addToBackStack(null)
                .commit()
        })
    }
}