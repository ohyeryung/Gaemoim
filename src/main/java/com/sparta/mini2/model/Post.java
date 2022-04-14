package com.sparta.mini2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.mini2.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Post extends Timestamped {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long postId;

    // nullable = false 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String post_content;

    @Column(nullable = false)
    private int frontNum;

    @Column(nullable = false)
    private int backNum;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(nullable = false)
    private int frontCnt;

    @Column(nullable = false)
    private int backCnt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"post"})
    private List<Front> front = new ArrayList<Front>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"post"})
    private List<Back> back = new ArrayList<Back>();


    // 게시글 생성
    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.nickName = requestDto.getNickName();
        this.position = requestDto.getPosition();
        this.post_content = requestDto.getPost_content();
        this.frontNum = requestDto.getFrontNum();
        this.backNum = requestDto.getBackNum();
        this.completed = requestDto.isCompleted();
        this.frontCnt = 0;
        this.backCnt = 0;

    }

    //게시글 수정
    public void update(Long postId, String title, String post_content, int frontNum, int backNum, boolean completed) {
        this.postId = postId;
        this.title = title;
        this.post_content = post_content;
        this.frontNum = frontNum;
        this.backNum = backNum;
        this.completed = completed;
    }
}