package com.example.androidseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidseminar.databinding.FollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowerViewHolder {
        val binding = FollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }
    override fun getItemCount(): Int = userList.size

    class FollowerViewHolder(private val binding: FollowerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data: UserData){
                binding.nameTextview.text=data.name
                binding.introductionTextview.text=data.introduction
            }
        }

}