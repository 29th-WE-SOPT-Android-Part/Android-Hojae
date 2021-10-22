package com.example.androidseminar

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this,R.layout.activity_home)
        val user = User("이호재","25","infp","간단한 자기소개 안녕하세요~~~")
        binding.user=user
        initTransactionEvent()
        setContentView(binding.root) // 자바 객체를 전달
        //setContentView(R.layout.activity_home) : xml을 전달
    }

    private fun initTransactionEvent() {
        val fragment1 = FollowerListFragment()
        val fragment2 = RepositoryListFragment()

        binding.followerListButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_continer,fragment1)
            transaction.commit()
        }
        binding.repositoryListButton.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_continer,fragment2)
            transaction.commit()
        }

    }
}