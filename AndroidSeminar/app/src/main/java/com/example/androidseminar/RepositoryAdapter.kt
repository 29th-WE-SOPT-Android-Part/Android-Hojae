package com.example.androidseminar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidseminar.databinding.RepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {
    val repositoryList = mutableListOf<RepositoryData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryViewHolder {
        val binding = RepositoryListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }
    override fun getItemCount(): Int = repositoryList.size

    class RepositoryViewHolder(private val binding: RepositoryListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepositoryData){
            binding.repositoryName.text=data.repository_name
            binding.repositorySummary.text=data.repository_introduction
        }
    }

}