![header](https://capsule-render.vercel.app/api?type=slice&color=gradient&height=200&section=header&text=당근마켓클론코딩&fontSize=90&animation=fadeIn&fontAlignY=38&desc=%20&descAlignY=62&descAlign=62)

<br>

## 🥕 프로젝트명 : 당근마켓 클론 코딩

![당근마켓]()

<br>

#### 이번 프로젝트에서는 사람들이 자주 사용하는 당근마켓의 웹페이지를 클론 코딩을 했습니다.<br><br> 실제 당근마켓 웹페이지에 없는 로그인, 회원가입 기능, 소셜로그인, 로그인 후 권한을 바탕으로 글 CRUD와 댓글 CRUD, 무한 스크롤을 추가하여 구현하였습니다! 🤗<br><br>

[당근마켓](https://www.daangn.com/)

<br>

# 🥕 당근마켓 클론코딩 - 8조 클론 코딩

## 🕒 제작기간

<br/>

### 2022년 6월 17일 ~ 2022년 6월 23일

<br/>
<br/>

## ✨ Developers

<br/>

- **Front-end**

    - 최지훈 [Github](https://github.com/Choiji92)
    - 임준수 [Github](https://github.com/junsu0121)
      <br/>
      <br/>

- **Back-end** : [Back-end repo](https://github.com/waryongc/clonecoding_8BE)

    - 고승유 / 김민지 / 박종인

  <br/>

  - 기본 기능:
      - 게시글 CRUD, 로그인 회원가입
      - 추가 기능:
          - 모달 창 플로팅
          - 소셜로그인(OAuth)
          - 댓글 기능
          - 좋아요 기능
          - 검색 기능
          - 사진 업로드 기능(다중 선택, 슬라이드)
          - gps 기능
          - 무한스크롤 기능

<br/>
<br/>

- 팀 notion : https://www.notion.so/8-c42cc76deaab4ba2b19e9a43fac2f71b

<br/>
<br/>
<br/>

## 🎨 프로젝트 초안

1. 메인페이지

![메인페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/45912cb3-5c6d-4199-b2a8-91c4b9d4df88/%E1%84%86%E1%85%A6%E1%84%8B%E1%85%B5%E1%86%AB.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T043311Z&X-Amz-Expires=86400&X-Amz-Signature=f82800410788500178d621252186735dbe590e7f905605fc0156238939eb5b85&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2586%25E1%2585%25A6%25E1%2584%258B%25E1%2585%25B5%25E1%2586%25AB.png%22&x-id=GetObject)

2. 로그인페이지 (모달창으로)

![로그인페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8b69d3e3-7f0d-4275-99e8-ca7c1efd9944/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-06-17_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_11.55.57.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T043511Z&X-Amz-Expires=86400&X-Amz-Signature=4ea0d2459b5ed5e5e2f8af8ce93a7e45dfd194b0aa4da35f8a20f15f19f7ebc9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA%25202022-06-17%2520%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB%252011.55.57.png%22&x-id=GetObject)

3. 회원가입페이지 (모달창으로)

![회원가입페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f03c0986-55f4-40c4-ad93-817ec2fbde9f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-06-17_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_11.54.39.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T043616Z&X-Amz-Expires=86400&X-Amz-Signature=4c50911d1b8c3d273f169106b1c663dcb4285fb88c3c8ac50c60245e8e6d3b7d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA%25202022-06-17%2520%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB%252011.54.39.png%22&x-id=GetObject)

4. 게시글 조회페이지
   ![게시글 조회페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f438e072-64f7-4c61-b2cd-5fc57d17c0ea/%E1%84%85%E1%85%B5%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T043712Z&X-Amz-Expires=86400&X-Amz-Signature=56134ed560a47d5d71e74a0037588020e0419c9111bc9a60464d552144b4c7b6&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2585%25E1%2585%25B5%25E1%2584%2589%25E1%2585%25B3%25E1%2584%2590%25E1%2585%25B3.png%22&x-id=GetObject)

5. 게시글 상세페이지
   ![게시글 상세페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/26f15d8f-e6c7-4aa8-bf8d-f9d0688b7bd4/%E1%84%89%E1%85%A1%E1%86%BC%E1%84%89%E1%85%A6%E1%84%91%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8C%E1%85%B5.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220623%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220623T043746Z&X-Amz-Expires=86400&X-Amz-Signature=82d4207c2d916201d462b53dae455238fa26fbb09ce4ac08b34cc53da8743681&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22%25E1%2584%2589%25E1%2585%25A1%25E1%2586%25BC%25E1%2584%2589%25E1%2585%25A6%25E1%2584%2591%25E1%2585%25A6%25E1%2584%258B%25E1%2585%25B5%25E1%2584%258C%25E1%2585%25B5.png%22&x-id=GetObject)

<br/>
<br/>

## 🎬 시연영상

<br/>

https://youtube.com
<br/>
<br/>
<br/>

## 📖 ERD 
___
![img_2.png](img_2.png)

## 🗒️ 페이지 & 기능

<br/>



### 1. 로그인, 회원가입

- JWT를 사용하여 로그인과 회원가입을 구현
- 회원정보 DB에 저장
- 로그인시 token 발급
- 토큰과 유저정보를 로컬스토리지에 저장해서 사용
- 아이디 및 닉네임 중복 확인과 2차 비밀번호 확인 가능 (벨리데이션 추가 완료)
- 로그인 회원가입 페이지 모달창으로 플로팅, 완료 후 모달창 사라지도록 구현
- 회원가입 시 유저의 위치정보를 얻을 수 있는 gps 기능 구현

### 2. 메인 페이지

- 당근 마켓 웹페이지와 동일한 구성
- 중고거래 인기매물 하단에서 확인 기능 구현
- 인기매물 버튼 클릭 시 컨텐츠 페이지로 이동하도록 구현
- 다른 부가적인 정보를 보여주는 버튼들은 당근마켓 웹페이지로 이동하도록 구현
- 헤더 부분에 로그인한 유저의 닉네임 확인 가능

### 3. 컨텐츠 페이지

- 모든 유저가 작성한 컨텐츠를 최신 순으로 확인 가능
- 해당 컨텐츠 클릭시 상세 페이지로 이동
- 모든 컨텐츠에 좋아요를 누를 수 있음(단, 하나의 컨텐츠에 같은 아이디로 좋아요 여러번 못함)
- 로그인을 한 상태시 글 작성 가능 기능 구현
- 좋아요 개수와 댓글 개수 확인 기능 구현
- 처음에 컨텐츠를 8개만 볼 수 있고 스크롤을 내릴 때마다 8개씩 추가로 더 볼 수 있음(무한 스크롤)

### 4. 컨텐츠 작성 페이지

- 타이틀,내용,이미지 모두 작성해야 작성버튼이 활성화 됨
- 이미지 업로드시 미리보기 구현
- 다중 이미지 첨부 기능 구현
- 로그인을 안한 상태로 글 작성 페이지에 들어오면 로그인을 하라는 메시지가 보이는 페이지로 이동

### 5. 컨텐츠 상세 페이지

- 해당 컨텐츠를 개시한 작성자만 컨텐츠를 수정, 삭제할 수 있는 버튼이 활성화 됨
- 모든 유저가 작성한 댓글을 최신순으로 확인 가능
- 해당 댓글 작성자만 댓글 수정, 삭제할 수 있는 버튼이 활성화 됨
- 상세 페이지에서도 해당 컨텐츠 좋아요 가능

### 6. 컨텐츠 수정 페이지

- 기존 컨텐츠의 정보들(타이틀,내용,이미지)이 그대로 유지되서 보여짐

### 7. 헤더 컴포넌트

- 모든 페이지에서 전역으로 보여짐
- 로그인 여부 확인 후 로그인, 회원가입, 당근채팅 버튼 활성화 기능 구현
- 검색창과 검색기능 구현
- 로그인 시 유저네임과 기본 프로필 이미지 보여짐

## 📐 API 설계
___
![img_3.png](img_3.png)
![img_4.png](img_4.png)

<br/>

## 🚀 Tech Stack

- **Front-end Tech Stack**
  <br/>
  <br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
  <img src="https://img.shields.io/badge/Create React App-09D3AC?style=for-the-badge&logo=Create React App&logoColor=white">
  <img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=Redux&logoColor=white">
  <img src="https://img.shields.io/badge/axios-2C5BB4?style=for-the-badge&logo=axios&logoColor=white">
  <br/>
  <img src="https://img.shields.io/badge/React Router Dom-CA4245?style=for-the-badge&logo=React Router Dom&logoColor=white">
  <img src="https://img.shields.io/badge/styled-components-DB7093?style=for-the-badge&logo=styled-components&logoColor=white">
  <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">

- **Front-end Library**

|            라이브러리명            |          내용           |  참고   |
|:----------------------------:|:---------------------:|:-----:|
|            axios             |         서버통신          |       |
|       react-router-dom       |          렌더링          |       |
|         react-redux          |         상태관리          |       |
|       @reduxjs/toolkit       |    Redux를 더 쉽게 사용     |       |
|         react-slick          |       이미지 슬라이드        |       |
|        slick-carousel        |       이미지 슬라이드        |       |
|         json-server          |       목업 데이터 관리       |       |
| react-intersection-observer  |         무한스크롤         |       |
|    react-hook-geolocation    |         gps기능         |       |
|    intersection-observer     |          옵저버          |       |
|         fortawesome          |        아이콘 툴킷         |       |
|      styled-components       |          css          |       |
    

- **Back-end Tech Stack**

  <br/>
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white">
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white">
  <img src="https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00">
  <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white">
  <img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">


- **Back-end Library**

|     라이브러리명      |               내용                |  참고   |
|:---------------:|:-------------------------------:|:-----:|
|       JWT       |               토큰                |       |
|     AWS S3      |             이미지 업로드             |       |
|       EC2       |              서버배포               |       |
|       JPA       | ORM(Object Realational Mapping) |       |
|   PAGINATION    |              무한스크롤              |       |
|      OAuth      |       소셜로그인(카카오, 네이버, 구글)       |       |
| Spring Security |         CORS, 로그인 권한 설정         |       |
|      Redis      |              진행 예정              |       |
|   Web Socket    |              진행 예정              |       |

<br>

## 💬 Front-end

> 이번 프로젝트는 지난주 미니프로젝트를 마치고 두번째로 프론트엔드와 백엔드가 함께 협업하여 진행한 프로젝트입니다.
> 우선적으로 주특기 주차와 지난주 사용하였던 로그인, 회원가입 및 CRUD 기능을 우선적으로 구현했으며,
> 기본적인 기능 구현을 끝낸 후 구현해보고 싶은 새로운 기술스택 및 디자인패턴을 도입하려 노력했습니다.
>
> ![Footer](https://capsule-render.vercel.app/api?type=waving&color=gradient&height=200&section=footer)

## 💬 Back-end

> 두 번째 협업을 거치면서 프론트끼리 또는 백끼리뿐만 아니라 프론트와 백끼리도 충분한 커뮤니케이션이 이루어져야 한다는것을 뼈저리게 느낄 수 있는 프로젝트였습니다.
> 프론트엔드분들과 함께 로그인을 비롯한 CRUD 등 기본적인 기능들과 이후에 쓰게 될 수 있는 무한스크롤의 구현 및 소켓 등 다른 응용 기술들의 시도를 경험할 수 있는 값진 시간이었습니다.
> 같은 백엔드, 프론트끼리라도 이전에 구현해봤던 기능들의 종류에 따라 프로젝트의 어떤 부분을 맡을 수 있을지 가늠하는 척도가 되었기 때문에 다양한 기능구현의 경험을 쌓아야 하는 이유를 몸소 느꼈습니다.
> 
> ![Footer](https://capsule-render.vercel.app/api?type=waving&color=gradient&height=210&section=footer)