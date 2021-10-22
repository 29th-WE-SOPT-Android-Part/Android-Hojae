## ✅Level1  
### ✔***Home xml*** 
<img src="https://user-images.githubusercontent.com/91423342/138451598-689563f0-053d-4cf5-a141-bb62a1ae82f5.jpg" width="200" height="380"/> 

``` xml
     <!--팔로워 리스트 버튼 생성-->
    <Button
        android:id="@+id/followerList_button"
        android:layout_width="120dp"
        android:layout_height="wrap_content"
        android:backgroundTint="#F16A98"
        android:text="팔로워\n목록"
        android:layout_marginTop="10dp"
        app:layout_constraintEnd_toStartOf="@id/repositoryList_button"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/introduction_textview" />

    <!--레포지토리 리스트 버튼 생성-->
    <Button
        android:id="@+id/repositoryList_button"
        android:layout_width="120dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:backgroundTint="#FF9800"
        android:text="레포지토리\n목록"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/followerList_button"
        app:layout_constraintTop_toBottomOf="@id/introduction_textview" />

<!--프레그먼트를 HomeActivity에 띄워줄 FragmentContainerView 생성-->
<androidx.fragment.app.FragmentContainerView
    android:id="@+id/main_continer"
    app:layout_constraintTop_toBottomOf="@id/followerList_button"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```  

### ✔***Follower List Fragment***
<img src="https://user-images.githubusercontent.com/91423342/138447241-cf104c5b-b1fe-4b94-92f2-c9b2871a6d07.png" width="200" height="380"/>  

 - #### follower_list.xml : 이미지와 텍스트뷰를 사용하여 샘플 팔로워 리스트 1개를 생성    
 - #### FollowerListFragment  
 
``` kotlin  

class FollowerListFragment : Fragment() {
    private lateinit var followerAdapter: FollowerAdapter
    private var binding: FragmentFollowerListBinding? = null// xml에 있는 모든 뷰들을 묶음
    // ? !! => 변수가 null인지에 대한
    // ? = null일 수 있다. 클래스 명 뒤에 쓰면, 이 클래스 타입의 변수는 이 클래스의 객체거나 null이다.
    // 아무것도 안 붙인경우= null이 아니다. 클래스 명 뒤 / 변수 명뒤
    // !! = 이 변수는 null이 아니다. 변수명 뒤에 쓴다. ! 는 같지않다는 뜻이기 때문에 !!로 쓴다.
    // private lateinit var mainFollowerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFollowerListBinding.inflate(layoutInflater)
        followerAdapter = FollowerAdapter()

        binding!!.rvFollower.adapter = followerAdapter
        followerAdapter.userList.addAll(listOf(
            UserData("문다빈","안드로이드 파트장"),
            UserData("장혜령","IOS 파트장"),
            UserData("김우영","서버 파트장")
        ))
        // followerAdapter를 사용해 변경된 데이터를 적용시킨다.
        followerAdapter.notifyDataSetChanged()

        return binding!!.root // xml의 가장 큰 Constraintlayout을 반환. 걍 폴더째로 보낸다.는 뜻임
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
// Runtime error : 실행 중에 갑자기 꺼져버리는 에러 => 가장 피해야한다.
// 코드를 치면서 코드에서 에러가 나는 것을 보고싶다 실행하고 아는게 아니고
// 그래서 ? !!등을 사용하여 null로 인한 에러를 미연에 알아차리려고 하는 것
// null 안되는 값인 !!붙인 거에 null 넣으면 바로 코드에 빨간줄로 알려줌

// int, boolean 같은 기본자료형은 자동으로 0같은 자동 초기화값이 정해져있다
// 반면, 임의로 우리가 생성한 클래스들의 초기값은 보통 null이다.  
```
### ✔***Repository List Fragment***
<img src="https://user-images.githubusercontent.com/91423342/138475496-7db2ed78-9e17-4b5e-b33a-d4aad3a483c1.png" width="200" height="380"/>  

 - #### repository_list.xml : 이미지와 텍스트뷰를 사용하여 샘플 레포지토리 리스트 1개를 생성

``` xml  
 <TextView
        android:id="@+id/repository_name"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="레포지토리 이름"
        android:textStyle="bold"
        android:textSize="20dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintHorizontal_bias="0.1"
        />
    <!--layout_constraintHorizontal_bias : 비율로 수평선에서 뷰위치 지정 매우 유용한듯-->

    <TextView
        android:id="@+id/repository_summary"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="레포지토리 설명"
        android:textSize="15dp"
        app:layout_constraintStart_toStartOf="@id/repository_name"
        app:layout_constraintTop_toBottomOf="@id/repository_name"
        android:layout_marginTop="10dp"
        />

```  

 - #### RepositoryListFragment  
 
``` kotlin  

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

```
### ✔***Home Activity***  

``` kotlin  

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

```  
### ✔***Grid Layout***  
``` xml
 <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_repository"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
<!--GridLayoutManager, LinearLayoutManager로 변경-->
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager" 
        app:spanCount="2"
        tools:itemCount="3"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp"
        tools:listitem="@layout/repository_list"
        />  

```



