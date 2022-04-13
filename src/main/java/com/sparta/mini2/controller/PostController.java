package com.sparta.mini2.controller;

import com.sparta.mini2.dto.PostRequestDto;
import com.sparta.mini2.dto.PostResponseDto;
import com.sparta.mini2.model.Post;

import com.sparta.mini2.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {


    private final com.sparta.mini2.service.PostService PostService;
    private final com.sparta.mini2.service.UserService UserService;



    // 게시글 전체 조회  ,페이징처리
    @GetMapping("/api/post")
    public Page<Post> getPost(@PageableDefault(size = 5) Pageable pageable
//            @RequestParam("page")  int page,
//            @RequestParam("size") int size,
//            @RequestParam ("sortBy")  String sortBy,
//            @RequestParam ("isAsc")  boolean isAsc
    ) {
//
        return PostService.getPost(pageable);
    }

    //     게시글 특정 조회
    @GetMapping("/api/post/detail/{postId}")
    public Post getPostone(@PathVariable Long postId) {

        return PostService.getPostone(postId);
    }
    // 게시글 생성
    @PostMapping("/api/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto){

        return PostService.createPost(requestDto);
    }
    //게시글 수정
    @PutMapping("/api/post/{postId}")
    public PostResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        return PostService.update(postId, requestDto);
    }
    //게시글 삭제
    @DeleteMapping("/api/post/{postId}")
    public PostResponseDto deletePost(@PathVariable Long postId) {

        return PostService.deletePost(postId);
    }
}
