package com.mingkyy.MyDiary.oauth;

import com.mingkyy.MyDiary.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.List;

@Getter
public class MemberOAuth2User extends DefaultOAuth2User {

    private final Member member;

    public MemberOAuth2User(Member member, OAuthAttributes attributes) {
        super(
                List.of(new SimpleGrantedAuthority(member.getMemberType().name())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );

        this.member = member;
    }


}
