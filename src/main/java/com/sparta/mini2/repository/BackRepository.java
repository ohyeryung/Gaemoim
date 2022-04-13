package com.sparta.mini2.repository;



import com.sparta.mini2.model.Back;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BackRepository extends JpaRepository<Back, Long> {
    List<Back> findAllByPost(Post post);
    Optional<Back> findByUserAndPost(User user, Post post);
}
