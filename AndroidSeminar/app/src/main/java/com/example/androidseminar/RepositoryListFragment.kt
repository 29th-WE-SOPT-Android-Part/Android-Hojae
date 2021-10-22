package com.example.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidseminar.databinding.FragmentRepositoryListBinding


class RepositoryListFragment : Fragment() {
    private lateinit var repositoryAdapter : RepositoryAdapter
    private var binding : FragmentRepositoryListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRepositoryListBinding.inflate(layoutInflater)
        repositoryAdapter = RepositoryAdapter()

        binding!!.rvRepository.adapter = repositoryAdapter
        repositoryAdapter.repositoryList.addAll(listOf(
            RepositoryData("안드로이드 과제 레포지토리","안드로이드 과제")
            ,RepositoryData("IOS 과제 레포지토리","IOS 과제")
            ,RepositoryData("서버 과제 레포지토리","서버 과제")
        ))
        repositoryAdapter.notifyDataSetChanged()
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}