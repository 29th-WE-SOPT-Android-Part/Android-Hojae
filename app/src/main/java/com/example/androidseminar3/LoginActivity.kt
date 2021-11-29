package com.example.androidseminar3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidseminar3.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.btnLogin.setOnClickListener {
            initNetwork()
        }

        setContentView(binding.root)
    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            id = binding.etId.text.toString(),
            password = binding.etpass.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)

        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call:Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@LoginActivity,"${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity,SecondActivity::class.java))
                } else
                    Toast.makeText(this@LoginActivity,"로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", " error:$t")
            }
        })
    }
}