## ver 71
- 게시글을 등록할 때 로그인 사용자의 ID를 저장하라!
- 학습목표
  - 테이블에 새 컬럼을 추가하는 방법을 익힌다.
  - 기존의 컬럼을 외부키 컬럼으로 만드는 방법을 배운다.
  
## 작업 목록 

### ex_board 테이블을 변경한다.
- 게시글 작성자 PK를 저장할 컬럼을 만든다.
- 그 컬럼이 ex_memb 테이블의 회원 번호를 참조하도록 외부키로 선언한다.
- "bitcamp-java-docs/bitcamp-java-project-v71.sql" 참조하라.

### Board 클래스에 작성자 정보를 담을 필드를 추가한다.

### BoardController 변경
- 세션에서 Member 정보를 가져와서 게시글을 등록할 때 전달한다.

### BoardDao.xml 변경
- insert SQL문을 변경한다.
- Board 파라미터 객체에서 작성자 번호를 꺼내 insert 할 때 사용한다.




