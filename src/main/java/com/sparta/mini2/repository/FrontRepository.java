package com.sparta.mini2.repository;


import com.sparta.mini2.model.Front;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FrontRepository extends JpaRepository<Front, Long> {
    List<Front> findAllByPost(Post post);
    Optional<Front> findByUserAndPost(User user, Post post);
}
