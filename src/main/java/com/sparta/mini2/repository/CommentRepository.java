package com.sparta.mini2.repository;


import com.sparta.mini2.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByPostIdOrderByCreatedAtDesc(Long postId , Pageable pageable);
}