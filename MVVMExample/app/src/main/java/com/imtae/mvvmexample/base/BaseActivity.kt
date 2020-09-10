package com.imtae.mvvmexample.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.imtae.mvvmexample.BR

abstract class BaseActivity <B : ViewDataBinding, VM: BaseViewModel>(
    @LayoutRes private val layoutResId: Int
) : AppCompatActivity() {

    private lateinit var binding: B

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this
    }
}