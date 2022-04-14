package com.sparta.mini2.controller;


import com.sparta.mini2.dto.FrontResponseDto;
import com.sparta.mini2.security.UserDetailsImpl;
import com.sparta.mini2.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontController {
    private final FrontService frontService;

    @Autowired
    public FrontController(FrontService frontService) {
        this.frontService = frontService;
    }

    // 프론트엔드 - 프로젝트 참여하기 (좋아요 기능 활용)
    @PostMapping("/api/front/{postId}")
    public FrontResponseDto clickFront(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return frontService.clickFront(postId, userDetails);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String nullex(IllegalArgumentException e) {
        return e.getMessage();
    }
}
