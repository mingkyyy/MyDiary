package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    public void member_save(){

        String name = "김민경";
        String email = "test12@test.com";
        String nickname = "mingkyy";
        memberRepository.save(Member.builder()
                        .name(name)
                        .nickname(nickname)
                        .email(email)
                .build());
        Member member = memberRepository.findAll().get(0);

        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getNickname()).isEqualTo(nickname);
        assertThat(member.getEmail()).isEqualTo(email);
    }
}
