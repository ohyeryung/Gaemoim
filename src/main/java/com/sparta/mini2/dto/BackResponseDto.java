package com.sparta.mini2.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackResponseDto {
    private String  username;
    private boolean isJoin;
    private boolean isCompleted;
    private int backCnt;

}
