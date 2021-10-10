package com.example.androidseminar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidseminar.databinding.ActivitySigninBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val signUpActivityIntent = Intent(this, SignUpActivity::class.java)
        // intent란??
        // 명시적 인텐트, 암시적 인텐트
        // 지금은 명시적 인텐트 -> 명시적으로 어느 액티비티 또는 컴포넌트를 실행할지 미리 결정
        // 이 코드는 SignUpActivity라는 컴포넌트(액티비티))를 실행할 것을 써준거임
        // 인텐트는 만든다고 끝이 아니고 여기에 추가적으로 데이터를 넣을 수 있음.
        // 인텐트는 또 다시 다른 startactivity같은 함수에 변수로 넣어서 전달하여 새 화면을 띄움

        // 암시적 인텐트
        // 예시)) 구글에서 이미지 공유할 때 여러 앱 종류를 보여줌.. -> 미디어 파일을 공유할 수 있는 기능을
        // 가진 여러 앱 중에 하나를 선택할 수 있게 해줌
        // 이처럼 사용자가 어떤 앱을 선택할 지 모르는 상태에서 특정한 작업을 수행할 수 있는 애들 중에서 고를 수 있게 해줌
        // 인텐트는 만든다고 끝이 아니고 여기에 추가적으로 데이터를 넣을 수 있음.
        // 인텐트는 또 다시 다른 startactivity같은 함수에 변수로 넣어서 전달하여 새 화면을 띄움

        // ! -> 이 객체가 절대 null은 아니다를 클래스 타입과 함께 표시해줄 때 써줌
        // ? -> null일 수도 있고 아닐 수도 있다.
        // !! -> 절대 null이 아님을 표시, 대신 대입한 값이 null이면 런타임 에러가 남


        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback<ActivityResult> {
                if (it.resultCode == RESULT_OK) {
                    binding.idEditText.setText(it.data?.getStringExtra("id"))
                    binding.pwEditText.setText(it.data?.getStringExtra("pw"))
                }
            })

        binding = ActivitySigninBinding.inflate(layoutInflater) // binding에 xml에 있는 뷰들을 java 객체로 만들어줄 (layoutInflater) 넣었다.
        // layoutInflater : xml에 있는 뷰들을 java객체로 만들어주는 애.
        // inflate() :
        // layoutinflater 를 inflate에 넣으면 뭐가 나오고 그거를 다시 binding이라는 변수에 넣었따.
        // binding : xml에 써놓은 뷰들이 자바객체(View)로 생기고, 그 객체들의 이름은 xml에 써놓은 아이디를 낙타표기법으로 바꾼 것이 된다.

        binding.loginButton.setOnClickListener {
            val idIsEmpty = binding.idEditText.text.isBlank()
            val passwordIsEmpty = binding.pwEditText.text.isBlank()

            if (idIsEmpty || passwordIsEmpty) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            } else {
                val homeActivityIntent = Intent(this, HomeActivity::class.java)
                startActivity(homeActivityIntent)
                Toast.makeText(this, "000님 환영합니다", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signupButton.setOnClickListener {
            resultLauncher.launch(signUpActivityIntent)
            //startActivity(signUpActivityIntent)
        }
        setContentView(binding.root)
    }


}

