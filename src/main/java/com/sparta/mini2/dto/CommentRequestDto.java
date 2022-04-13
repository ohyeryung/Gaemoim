package com.sparta.mini2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequestDto {
    private Long commentId;
    private Long postId;
    private String username;
    private String nickName;
    private String position;
    private String comment_content;
}