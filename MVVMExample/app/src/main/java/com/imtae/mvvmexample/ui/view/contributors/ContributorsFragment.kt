package com.imtae.mvvmexample.ui.view.contributors

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.imtae.mvvmexample.R
import com.imtae.mvvmexample.base.BaseFragment
import com.imtae.mvvmexample.databinding.FragmentContributorsBinding
import com.imtae.mvvmexample.ui.adapter.ContributorsAdapter
import kotlinx.android.synthetic.main.fragment_contributors.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContributorsFragment : BaseFragment<FragmentContributorsBinding, ContributorsViewModel>(
    R.layout.fragment_contributors
) {

    override val viewModel : ContributorsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getContributors()

        viewModel.contributorList.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter?.notifyDataSetChanged()
            recyclerView.adapter = ContributorsAdapter(it)
        })
    }

}