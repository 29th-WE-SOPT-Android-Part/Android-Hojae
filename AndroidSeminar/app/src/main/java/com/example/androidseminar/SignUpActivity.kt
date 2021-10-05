package com.example.androidseminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidseminar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.signinCompleteButton.setOnClickListener {
            val nameIsEmpty : Boolean = binding.nameEditText.text.isBlank()
            val idIsEmpty : Boolean = binding.idEditText.text.isBlank()
            val passwordIsEmpty : Boolean = binding.passwordEditText.text.isBlank()

            if (nameIsEmpty||idIsEmpty||passwordIsEmpty) {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
            }
            else {
                finish() // signinactivity에서 명시적 인텐트를 통해서 왔으면 엑티비티에 스택이 쌓인다. 그래서 최근 액티비티를 끝내주면 깔려있던 액티비티가 다시 앞으로 나온다.
            }
        }
        setContentView(binding.root) // ??
    }
}