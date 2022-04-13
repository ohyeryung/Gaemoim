package com.sparta.mini2.dto;


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
public class FrontRequestDto {
    public Front toFrontEntity(Post post, User user) {
        return Front.builder()
                .user(user)
                .post(post)
                .build();
    }
}
