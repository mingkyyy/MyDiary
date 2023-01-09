package com.mingkyy.MyDiary.repository;

import com.mingkyy.MyDiary.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
