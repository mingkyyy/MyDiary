package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
