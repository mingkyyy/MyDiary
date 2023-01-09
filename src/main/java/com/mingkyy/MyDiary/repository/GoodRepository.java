package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Long> {
}
