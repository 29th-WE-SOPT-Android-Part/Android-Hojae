package com.example.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidseminar.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater) // binding에 xml에 있는 뷰들을 java 객체로 만들어줄 (layoutInflater) 넣었다.
        // layoutInflater : xml에 있는 뷰들을 java객체로 만들어주는 애.
        // inflate() :
        // layoutinflater 를 inflate에 넣으면 뭐가 나오고 그거를 다시 binding이라는 변수에 넣었따.
        // binding : xml에 써놓은 뷰들이 자바객체(View)로 생기고, 그 객체들의 이름은 xml에 써놓은 아이디를 낙타표기법으로 바꾼 것이 된다.

        binding.loginButton.setOnClickListener {
            val idIsEmpty = binding.idEditText.text.isBlank()
            val passwordIsEmpty = binding.pwEditText.text.isBlank()

            if (idIsEmpty || passwordIsEmpty) {
                Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
            } else {
                val homeActivityIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeActivityIntent)
                Toast.makeText(this, "000님 환영합니다", Toast.LENGTH_SHORT).show()
            }
        }
        binding.signupButton.setOnClickListener {
            val signUpActivityIntent = Intent(this,SignUpActivity::class.java) // ??
            startActivity(signUpActivityIntent)
        }
        setContentView(binding.root)
    }


}

