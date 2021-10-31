package com.example.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.androidseminar.databinding.FollowerListBinding
import com.example.androidseminar.databinding.FragmentFollowerListBinding


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
        //변경된 데이터 적용시킨다.
        followerAdapter.notifyDataSetChanged()

        return binding!!.root // xml의 가장 큰 Constraintlayout을 반환. 걍 폴더쨰로 보낸다.는 뜻임
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
