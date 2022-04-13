package com.sparta.mini2.dto;


import com.sparta.mini2.model.Back;
import com.sparta.mini2.model.Front;
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
public class BackRequestDto {
    public Back toBackEntity(Post post, User user) {
        return Back.builder()
                .user(user)
                .post(post)
                .build();
    }
}
