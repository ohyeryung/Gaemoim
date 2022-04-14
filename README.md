# mini22

## Webmini project2 "개모임" Backend

만들고 싶은 프로젝트가 있을 때 함께 만들어갈 동료를 구하는 공간
<br>
만들고 싶은 서비스는 많은데 팀원을 어떻게 구해야할지 모르겠고, 취업 포트폴리오는 만들어야하는데 아이디어는 떠오르지 않아 막막했던적 없으신가요? ‘개발자들의 모임’ <개.모.임>은 이러한 고민을 갖고 있는 개발자들을 위한 Social Recruiting Network Service 입니다. 취업준비는 하고 싶은데 포트폴리오가 없어 난항을 겪는 개발자들,또는 아이디어는 넘쳐나는데 함께할 팀원이 없어 낙심하는 개발자들을 많이 보았습니다. 그렇다고 네트워크를 만들기 위해 학원이나 부트캠프를 다니기엔 부담스럽기도 하죠. 이러한 고민을 갖고 있는 개발자들의 크고 작은 도전에 한 발짝 보탬이 되고자 서비스를 만들어 보았습니다.
<br>

## **Frontend github link**

[hanghae99-gaemoim-FE](https://github.com/kiwonbyun/hanghae99-gaemoim-FE/tree/main/gaemoim_fe)
<br>

## 팀원

- Frontend: 서유나, 변기원
- Backend: 지수민, 김빛찬, 엄성훈, 오예령
  <br>

## 진행기간

- 2022.04.08(금) ~ 2022.04.14(목)
  <br>

## 개발 도구 및 환경

주요 구현: Java&Spring Framework(Springboot, SpringSecurity, Spring Data JPA 등)

JWT 생성/활용: jwt

코드 간소화: lombok

DB: AWS Amazon RDS

RDB 엔진: MySQL

서버 호스팅: EC2

<br>

<h3 align="center"><b>📂 Project Directory Structure 📁</b></h3>

<pre>
<code>
/com.sparta.Webmini2
  └──/controller
     ├── /BackController.java
     ├── /CommentController.java
     ├── /FrontController.java
     ├── /PostController.java
     └── /UserController.java
  └──/dto
     ├── /BackRequestDto.java
     ├── /BackResponseDto.java
     ├── /CommentRequestDto.java
     ├── /CommentResponseDto.java
     ├── /FrontRequestDto.java
     ├── /FrontResponseDto.java
     ├── /PostRequestDto.java
     ├── /PostResponseDto.java
     ├── /ResponseDto.java
     └── /SignupRequestDto.java
  └──/model
     ├── /Back.java
     ├── /Comment.java
     ├── /Front.java
     ├── /Post.java
     ├── /Timestamped.java
     └── /User.java
  └──/repository
     ├── /BackRepository.java
     ├── /CommentRepository.java
     ├── /FrontRepository.java
     ├── /PostRepository.java
     └── /UserRepository.java
  └──/security
     └── /filter
         ├── /FormLoginFilter.java
         └── /JwtAuthFilter.java
     └── /jwt
         ├── /HeaderTokenExtractor.java
         ├── /JwtDecoder.java
         ├── /JwtPreProcessingToken.java
         └── /JwtTokenUtils.java
     └── /provider
         ├── /AuthFailureHandler.java
         ├── /FilterSkipMatcher.java
         ├── /FormLoginSuccessHandler.java
         ├── /UserDetailsImpl.java
         ├── /UserDetailsServiceImpl.java
         └── /WebSecurityConfig.java
  └──/service
     ├── /BackService.java
     ├── /CommentService.java
     ├── /FrontService.java
     ├── /PostService.java
     └── /UserService.java
  └──/validator
     └── /UserInfoValidator.java
  └──/Mini22Application.java
</code>
</pre>