# Board project (Spring Boot Admin page TEST) with Spring data JPA

## 환경
JAVA Version : 11
SpringFrameWork Boot version: 2.5.8
DB: mysql
IDE: IntelliJ

## 실행방법
1. Gradle을 빌드하고 SpringBoot BoardApplication 을 실행한다.
2. 크롬이나 사파리 브라우저에서 url (localhost:8080)으로 접속하면 게시판 화면이 나온다.
3. 게시글을 조회, 생성, 수정, 삭제 한다.

## BoardController
화면과 요청, 응답을 주고 받는 controller 객체, crud 가 GET, POST를 이용해 구현 되어있음 

## JSP
webapp/WEB-INF 에 JSP 파일 작성해두었고, application.properties에 prefix, suffix로 resolver 등록해두었습니다.
