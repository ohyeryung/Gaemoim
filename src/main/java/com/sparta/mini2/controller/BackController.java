package com.sparta.mini2.controller;

import com.sparta.mini2.dto.BackResponseDto;
import com.sparta.mini2.security.UserDetailsImpl;
import com.sparta.mini2.service.BackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackController {
    private final BackService backService;

    @Autowired
    public BackController(BackService backService) {
        this.backService = backService;
    }

    // 백엔드 - 프로젝트 참여하기 (좋아요 기능 활용)
    @PostMapping("/api/back/{postId}")
    public BackResponseDto clickBack(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return backService.clickBack(postId, userDetails);
    }
}
