package com.sparta.mini2.service;


import com.sparta.mini2.dto.CommentRequestDto;
import com.sparta.mini2.dto.CommentResponseDto;
import com.sparta.mini2.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final com.sparta.mini2.repository.CommentRepository commentRepository;

    //댓글 생성
    public CommentResponseDto createComment(Long postId, CommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = null;
        Comment comment = new Comment(postId,requestDto);
        commentRepository.save(comment);
        commentResponseDto = new CommentResponseDto(true);
        return commentResponseDto;
    }

    //댓글 전체조회
    public Page<Comment> getComment(Long postId , Pageable pageable) {
        return commentRepository.findAllByPostIdOrderByCreatedAtDesc(postId , pageable);
    }

    //댓글 수정 후 확인
    @Transactional
    public CommentResponseDto update(Long commentId, CommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = null;
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto.getComment_content());
        System.out.println(comment.getComment_content());
        commentResponseDto = new CommentResponseDto(true);
        return commentResponseDto;
    }

    //댓글 삭제
    public CommentResponseDto deleteComment(Long commentId) {
        CommentResponseDto commentResponseDto = null;
        commentRepository.deleteById(commentId);
        commentResponseDto = new CommentResponseDto(true);
        return commentResponseDto;
    }

    // 댓글 수정 전 보여주기
    public Comment showcomment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        return comment;
    }
}