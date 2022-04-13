package com.sparta.mini2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private Long postId;
    private String username;
    private String nickName;
    private String position;
    private String title;
    private int frontNum;
    private int backNum;
    private String post_content;
    private boolean completed;
}
