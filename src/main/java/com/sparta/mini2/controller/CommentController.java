package com.sparta.mini2.controller;

import com.sparta.mini2.dto.CommentRequestDto;
import com.sparta.mini2.dto.CommentResponseDto;
import com.sparta.mini2.model.Comment;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.repository.CommentRepository;

import com.sparta.mini2.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository CommentRepository;
    private final CommentService commentService;

    //  댓글 전체 조회
    @GetMapping("/api/comments/{postId}")
    public Page<Comment> getComment(@PathVariable Long postId ,@PageableDefault(size = 5) Pageable pageable) {
        return commentService.getComment(postId , pageable);
    }
    // 댓글 생성
    @PostMapping("/api/comments/{postId}")
    public CommentResponseDto createComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto){

        return commentService.createComment(postId, requestDto);
    }
    // 댓글 수정
    @GetMapping("/api/comments/edit/{commentId}")
    public Comment showcomment(@PathVariable Long commentId) {
        return commentService.showcomment(commentId);
    }

    // 댓글 수정 확인
    @PutMapping("/api/comments/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return commentService.update(commentId, requestDto);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public CommentResponseDto deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

}