## ✅Level1
### ✔***POSTMAN 테스트***
<img src="https://user-images.githubusercontent.com/91423342/141465927-4efe5b4c-b8bf-4e4c-9ed9-17047ad95806.png" width="1200" height="600"/>  

- #### 회원가입 완료
        POSTMAN의 POST 메소드를 통해서, json형식의 데이터를 서버에 제출하였다.
        => Response단에서 정상작동 확인!
 

<img src="https://user-images.githubusercontent.com/91423342/141466018-de89a2c1-378a-46c4-8232-146372e3f1a4.png" width="1200" height="600"/>  

- #### 로그인 완료
        POSTMAN의 GET 메소드를 통해서, 저장되어있는 데이터를 서버에서 조회하였다.
        기존 저장데이터외에 신규 제출된 데이터는 서버에 저장되지 않아서 서팟장님 이메일로 조회를 진행해보았다.
        => Response단에서 정상작동 확인!

### ✔***서버통신 실습***  
<img src="https://user-images.githubusercontent.com/91423342/141467917-d14a3af4-5acd-428b-b504-74c7617d12e5.png" width="200" height="380"/>  <img src="https://user-images.githubusercontent.com/91423342/141467950-60b3eac3-84b9-4f3b-9e0b-8a74da6d544c.png" width="200" height="380"/> 

- #### RequestLoginData  
``` kotlin  
 //서버에 제출한 데이터양식을 객체로 구현하였다.
  data class RequestLoginData(
    @SerializedName("email") //이때 email은 json에서 사용하는 키값 id와 다르므로 @SerializedName 어노테이션으로 보완하였다.
    val id : String,
    val password : String
)

```  
- #### ResponseLoginData  
``` kotlin  
 //서버에서 받아올 데이터양식을 객체로 구현하였다.
  data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data : Data //여기서 data는 변수가 아닌 객체이므로 중괄호를 사용하여 중첩클래스 형식으로 구현하였다.
) {
    data class Data( 
        val id : Int,
        val name : String,
        val email : String
    )
}  
```  
- #### Sample Service  
``` kotlin  
//POSTMAN에서 했던 서버통신을 구현하는 인터페이스 생성
 interface SampleService {
    @Headers("Content-Type:application/json")
    @POST("user/login") // POST메서드를 사용
    fun postLogin(
        @Body body:RequestLoginData // Body에 RequestBody 데이터가 input되면
    ) : Call<ResponseLoginData> 
}  // ResponseLoginData가 서버로부터 return
```  
- #### Service Creator  
``` kotlin  
// Retrofit Interface 객체만들기 :  Retrofit 객체를 생성 -> Retrofit을 사용해 SampleService 객체를 생성
  object ServiceCreator {
    private const val BASE_URL =  "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

//1단계 : Retrofit 객체를 생성
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
//2단계 : Retrofit을 사용해 SampleService 객체를 생성
    val sampleService:SampleService = retrofit.create(SampleService::class.java)

}
```    
- #### LoginActivity  
``` kotlin  
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
    // 서버에 전달할 RequestLoginData 객체 생성
    // 로그인화면의 editText의 정보전달
        val requestLoginData = RequestLoginData(
            id = binding.etId.text.toString(),
            password = binding.etpass.text.toString()
        )

        val call: Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
        
        //enqueue 메서드로 비동기 호출 선택
        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call:Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data
                    //로그인 성공시 토스트 메시지 호출
                    Toast.makeText(this@LoginActivity,"${data?.email}님 반갑습니다!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity,SecondActivity::class.java))
                } else
                    //로그인 실패시 토스트 메시지 호출
                    Toast.makeText(this@LoginActivity,"로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
            }
            // 비동기 통신중 에러를 처리
            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", " error:$t")
            }
        })
    }
}
```  

