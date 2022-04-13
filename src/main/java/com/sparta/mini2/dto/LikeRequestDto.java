package com.sparta.mini2.dto;


import com.sparta.mini2.model.Likes;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class LikeRequestDto {
    public Likes toEntity(Post post, User user) {
        return Likes.builder()
                .user(user)
                .post(post)
                .build();
    }
}
