package com.sparta.mini2.model;

import com.sparta.mini2.dto.BackResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Back {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    public BackResponseDto toBackDto(boolean bool, boolean completed, int backCnt) {
        return BackResponseDto.builder()
                .username(user.getUsername())
                .isJoin(bool)
                .isCompleted(completed)
                .backCnt(backCnt)
                .build();
    }
}
