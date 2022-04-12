package com.sparta.mini2.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private boolean result;
    private String errormessage;
    private String username;
    private String nickName;
    private String position;

    public ResponseDto(boolean result) {
        this.result = result;
    }

    public ResponseDto(boolean result, String message) {
        this.result = result;
        this.errormessage = message;
    }

    public ResponseDto(String username, String userNickName, String userPosition) {
        this.username = username;
        this.nickName = userNickName;
        this.position = userPosition;
    }
}
