package com.sparta.mini2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.mini2.dto.FrontResponseDto;
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
public class Front {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    public FrontResponseDto toFrontDto(boolean bool, boolean completed, int frontCnt) {
        return FrontResponseDto.builder()
                .username(user.getUsername())
                .isJoin(bool)
                .isCompleted(completed)
                .frontCnt(frontCnt)
                .build();
    }
}
