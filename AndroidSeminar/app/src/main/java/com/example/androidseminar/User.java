package com.example.androidseminar;

public class User {
    public User(String name, String age, String mbti, String intro) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMbti() {
        return mbti;
    }

    public String getIntro() {
        return intro;
    }

    private final String name;
    private final String age;
    private final String mbti;
    private final String intro;

}
