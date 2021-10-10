package com.example.androidseminar

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityHomeBinding.inflate(layoutInflater)

        binding.githubBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Grandelwald"))
            //action_view = 브라우저중에 선택할 수 있게해줍니다.
            startActivity(intent)
        }
        setContentView(binding.root) // 자바 객체를 전달
        //setContentView(R.layout.activity_home) : xml을 전달
    }


}