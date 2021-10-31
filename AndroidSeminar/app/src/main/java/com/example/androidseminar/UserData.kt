package com.example.androidseminar

data class UserData(
    val name : String,
    val introduction : String
)

// data class?
// class 앞에 data를 붙이면 => 생성자, get method , set method를 알아서 생성해주는 클래스
// JAVA의 pojo 클래스와 유사
// UserData("문다빈","안드 파트장") : UserData의 생성자에 초기화를 해준것
