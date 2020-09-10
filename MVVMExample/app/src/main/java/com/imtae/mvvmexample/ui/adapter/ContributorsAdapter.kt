package com.imtae.mvvmexample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imtae.mvvmexample.R
import com.imtae.mvvmexample.model.domain.Contributor
import com.imtae.mvvmexample.ui.adapter.viewholder.ContributorsViewHolder

class ContributorsAdapter(private val contributorsList: List<Contributor>) : RecyclerView.Adapter<ContributorsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContributorsViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contributors_item, parent, false)

        return ContributorsViewHolder(itemView)
    }

    override fun getItemCount(): Int = contributorsList.size

    override fun onBindViewHolder(holder: ContributorsViewHolder, position: Int) = holder.bindItems(contributorsList[position])
}