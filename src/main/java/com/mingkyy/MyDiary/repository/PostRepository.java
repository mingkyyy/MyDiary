package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
