package com.sparta.mini2.service;


import com.sparta.mini2.dto.LikeRequestDto;
import com.sparta.mini2.dto.LikeResponseDto;
import com.sparta.mini2.model.Likes;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.model.User;
import com.sparta.mini2.repository.LikeRepository;
import com.sparta.mini2.repository.PostRepository;
import com.sparta.mini2.repository.UserRepository;
import com.sparta.mini2.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public LikeResponseDto clickLike(Long postId, UserDetailsImpl userDetails) {
        LikeRequestDto likeRequestDto = new LikeRequestDto();
        // 해당 게시글을 전부 찾기
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("찾으시는 글이 존재하지 않습니다.")
        );
        // 좋아요 눌렀는지 확인하기
        Likes likesCheck = likeRepository.findByUserAndPost(userDetails.getUser(), post).orElse(null);
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        // 좋아요를 안눌렀을 경우(null) -> 라이크Repository에 포스트와 유저정보를 저장
        // 이후 해당 포스트의 좋아요 리스트 갯수를 센다음 게시글 Entity에 LikeCnt에 넣어준다.
        Likes likes = new Likes();
        if (likesCheck == null) {
            likes = likeRepository.save(likeRequestDto.toEntity(post, user));
            List<Likes> likesList = likeRepository.findAllByPost(post);

            post.setLikeCnt(likesList.size());

            //반환값으로 좋아요 누른 bool값과 게시글에대한 총 좋아요 갯수를 보낸다.

            return likes.toDto(true, likesList.size());
        }
        else {
            // 좋아요를 눌렀었을 경우, 요청이 들어오면 likeRepository에서
            likeRepository.deleteById(likesCheck.getId());

            List<Likes> likesList = likeRepository.findAllByPost(post);

            post.setLikeCnt(likesList.size());

            return likesCheck.toDto(false, likesList.size());
        }
    }
}
