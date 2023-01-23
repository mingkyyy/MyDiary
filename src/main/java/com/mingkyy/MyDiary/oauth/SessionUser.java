package com.mingkyy.MyDiary.oauth;

import java.io.Serializable;

import com.mingkyy.MyDiary.domain.Member;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }



}
