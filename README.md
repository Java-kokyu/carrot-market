GOOD NIGHT 🌙
KakaoTalk_Photo_2022-06-16-09-59-43 어떻게 해야 '좋은' 잠을 잘 수 있을까!? 잠이 필요한 분들을 위해서 정보를 공유할 수 있는 웹사이트 'Good Night'의 백엔드 서버입니다.

Demo Video
IMAGE ALT TEXT HERE

Environment


AWS EC2 서버의 t2.micro 환경에서 구동 중입니다.
DATABASE는 MongoDB를 활용 중이며 ec2 인스턴스에서만 접근 할 수 있습니다.

Technical Stacks
    
JAVASCRIPT, NODEJS, EXPRESS, MongoDB, JEST 를 활용합니다.

서버는 Amazon Web Service EC2 인스턴스에서 구동 중
Joi라이브러리를 활용한 이메일, 비밀번호 형식 구현
USER : 회원가입, 로그인 기능, 로그인 토큰을 이용해서 홈페이지 활동 권한 구현
POST : 게시글 작성, 삭제, 수정, 조회 구현
COMMENT : 댓글 작성, 수정, 삭제 구현
LIKE : 좋아요 추가, 삭제 구현
TEST : Jest라이브러리를 이용해 인증미들웨어 테스트코드 구현
Prerequisite
 
Node.js - Node.js 및 npm 패키지 관리자를 다운로드 및 설치합니다 . 문제가 발생하면 이 GitHub Gist 를 사용하여 Node.js를 설치할 수도 있습니다.
MongoDB - MongoDB 를 다운로드 및 설치 하고 기본 포트(27017)에서 실행 중인지 확인합니다.
ERD
이미지 2022  6  13  오후 6 05

API Design
스크린샷(477)
