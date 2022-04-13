package com.sparta.mini2.service;


import com.sparta.mini2.dto.FrontRequestDto;
import com.sparta.mini2.dto.FrontResponseDto;
import com.sparta.mini2.model.Back;
import com.sparta.mini2.model.Front;
import com.sparta.mini2.model.Post;
import com.sparta.mini2.model.User;
import com.sparta.mini2.repository.BackRepository;
import com.sparta.mini2.repository.FrontRepository;
import com.sparta.mini2.repository.PostRepository;
import com.sparta.mini2.repository.UserRepository;
import com.sparta.mini2.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FrontService {

    private final FrontRepository frontRepository;
    private final BackRepository backRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public FrontResponseDto clickFront(Long postId, UserDetailsImpl userDetails) {
        FrontRequestDto frontRequestDto = new FrontRequestDto();
        // 해당 게시글을 전부 찾기
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("찾으시는 글이 존재하지 않습니다.")
        );
        // 다른 포지션에서 참여를 햇는지 검사
        Back backCheck = backRepository.findByUserAndPost(userDetails.getUser(), post).orElse(null);
        if (backCheck != null) {
            throw new IllegalArgumentException("이미 백엔드에 참여를 하셨습니다.");
        }
        // 눌렀는지 확인하기
        Front frontCheck = frontRepository.findByUserAndPost(userDetails.getUser(), post).orElse(null);
        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        // 좋아요를 안눌렀을 경우(null) -> Repository에 포스트와 유저정보를 저장
        // 이후 해당 포스트의 리스트 갯수를 센다음 게시글 Entity에 Cnt에 넣어준다.
        Front front = new Front();
        if (frontCheck != null) {
            // 좋아요를 눌렀었을 경우, 요청이 들어오면 Repository에서
            frontRepository.deleteById(frontCheck.getId());

            List<Front> frontsList = frontRepository.findAllByPost(post);

            post.setFrontCnt(frontsList.size());
            post.setCompleted(false);
            return frontCheck.toFrontDto(false, false, frontsList.size());

        } else {
            // 모집이 완료되면 종료
            if (post.getFrontNum() == post.getFrontCnt()) {
                throw new IllegalArgumentException("정원 초과입니다.");
            }
            front = frontRepository.save(frontRequestDto.toFrontEntity(post, user));
            List<Front> frontList = frontRepository.findAllByPost(post);

            post.setFrontCnt(frontList.size());
            //만약 프론트 모집인원과 참여인원 수가 같은면 모집완료 처리
            if (post.getFrontNum() == post.getFrontCnt() && post.getBackNum() == post.getBackCnt()) {
                post.setCompleted(true);
                return front.toFrontDto(true, true, frontList.size());
            }
            //반환값으로 좋아요 누른 bool값과 게시글에대한 총 좋아요 갯수를 보낸다.
            return front.toFrontDto(true, false, frontList.size());
        }
    }
}
