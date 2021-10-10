
## ✅Level1
### ✔***SignInActivity***
<img src="https://user-images.githubusercontent.com/91423342/136684801-e5b4e55c-fd43-48a2-a77e-0a09caae2ef4.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136685841-31b27ab2-5025-449e-86f8-2bd6048fe8a0.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136685916-0070b78f-fe99-4862-abad-eeb11d418550.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136686074-7bcd86de-1822-4d85-a327-81005098270d.png" width="200" height="380"/>  

- #### 아이디

```xml
<EditText
        ...
        android:hint="아이디를 입력해주세요" // android:hint 속성에 텍스트를 입력해서 미리보기 속성을 구현
        android:inputType="text" // android:inputType 속성 중 text 설정으로 입력내용 보여짐  
        ...
        />
```
 - #### 비밀번호
``` xml
<EditText
        ...
        android:hint="비밀번호를 입력해주세요" // android:hint 속성에 텍스트를 입력해서 미리보기 속성을 구현  
        android:inputType="textPassword" // android:inputType 속성 중 textPassword 설정으로 입력내용 가려짐
        ...
        />
```
 - #### 로그인 버튼  
``` kotlin  
// loginButton을 클릭했을때, 
binding.loginButton.setOnClickListener {

// isBlank() 함수를 이용하여 아이디 / 패스워드 EditText뷰의 text가 비어있거나 스페이스 바만 쳐있는지 값을 반환
            val idIsEmpty = binding.idEditText.text.isBlank()
            val passwordIsEmpty = binding.pwEditText.text.isBlank()

// 두 EditText뷰 중 하나라도 값이 비어있다면, 니 실패했다고 Toast를 띄운다. homeActivity를 실행한다.
            if (idIsEmpty || passwordIsEmpty) {
                Toast.makeText(this,"로그인 실패", Toast.LENGTH_SHORT).show()
            }
            
// 둘 다 값이 들어있다면,            
            else {
                val homeActivityIntent = Intent(this, HomeActivity::class.java) // homeActivity의 정보를 homeActivityIntent 변수에 저장
                startActivity(homeActivityIntent) // startActivity 함수에 homeActivity 정보를 넣어주어, homeActivity를 실행
                Toast.makeText(this, "000님 환영합니다", Toast.LENGTH_SHORT).show() // 그리고 환영한다고 Toast 실행 
            }
        }  
```    
- #### 회원가입 버튼  
``` kotlin  
// signupButton을 클릭했을때,
 binding.signupButton.setOnClickListener {
            val signUpActivityIntent = Intent(this,SignUpActivity::class.java) // SignUpActivity의 정보를 signUpActivityIntent 변수에 저장
            startActivity(signUpActivityIntent) // startActivity 함수에 SignUpActivity 정보를 넣어주어, SignUpActivity를 실행
        }  
```     

### ✔***SignUpActivity***  
<img src="https://user-images.githubusercontent.com/91423342/136687013-04742960-c3ce-4964-bb9b-0ebbdf854c82.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136687075-fbd666f1-12f7-448a-abe8-25f8559af7dd.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136687103-5245a543-8336-4267-becd-6611f14300a7.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/136687142-96d748ca-3524-4cca-898f-d4718a973dcd.png" width="200" height="380"/>  

- #### 이름  
``` kotlin  
 <EditText  
        ...  
        android:hint="이름을 입력해주세요" // android:hint 속성에 텍스트를 입력해서 미리보기 속성을 구현    
        android:inputType="text"  // android:inputType 속성 중 text 설정으로 입력내용 보여짐  
        ...  
        />  
```  
- #### 아이디  
``` kotlin  
 <EditText  
        ...  
        android:hint="아이디를 입력해주세요"  // android:hint 속성에 텍스트를 입력해서 미리보기 속성을 구현
        android:inputType="text"  // android:inputType 속성 중 text 설정으로 입력내용 보여짐
        ...  
        />  
```  
- #### 비밀번호  
``` kotlin  
 <EditText  
        ...  
        android:hint="비밀번호를 입력해주세요"  // android:hint 속성에 텍스트를 입력해서 미리보기 속성을 구현
        android:inputType="textPassword"  // android:inputType 속성 중 textPassword 설정으로 입력내용 가려짐
        ...  
        />  
```  
- #### 회원가입 완료 버튼  
``` kotlin  
  binding.signinCompleteButton.setOnClickListener {
  // isBlank() 함수를 이용하여 이름 / 아이디 / 패스워드 EditText뷰의 text가 비어있거나 스페이스 바만 쳐있는지 값을 반환  
            val nameIsEmpty : Boolean = binding.nameEditText.text.isBlank()
            val idIsEmpty : Boolean = binding.idEditText.text.isBlank()
            val passwordIsEmpty : Boolean = binding.passwordEditText.text.isBlank()
            
 // EditText뷰 셋 중 하나라도 값이 비어있다면, 니 실패했다고 Toast를 띄운다.
            if (nameIsEmpty||idIsEmpty||passwordIsEmpty) {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
            }
            
 // 셋 다 값이 들어있다면, SignUpActivity를 끝내고 인텐트를 넘겨줬던 SignInActivity로 돌아간다.          
            else {
                finish() 
            }
        }
```    
### ✔***HomeActivity***  
<img src="https://user-images.githubusercontent.com/91423342/136687922-5a8aa7f4-17a0-44b3-9d45-5683b9294925.png" width="200" height="380"/>  

- #### 프로필 사진  

``` xml  
<ImageView
        android:id="@+id/profile_imageview"
        android:layout_width="160dp"
        android:layout_height="160dp"
        android:src="@drawable/profileimage" // drawable 폴더에 image룰 등록하여 사용하였다.
        android:layout_marginTop="40dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/title_textview"
        />
```  



