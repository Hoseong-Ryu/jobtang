package com.imtae.mvvmexample.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.imtae.mvvmexample.model.domain.Contributor
import kotlinx.android.synthetic.main.contributors_item.view.*

class ContributorsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(contributorsList: Contributor) {

        itemView.login.text = contributorsList.login
        itemView.user_id.text = contributorsList.id.toString()
    }
}