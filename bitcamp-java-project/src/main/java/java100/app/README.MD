## ver 72
- 게시글에 첨부파일 붙이는 기능을 추가하라!
- 학습목표
  - 멀티파트 형식으로 업로드 파일을 처리하는 방법을 익힌다.
  - 게시글 테이블과 첨부파일 테이블 데이터를 조인하여 가져오는 방법을 배운다.

## 작업 목록 

### 첨부 파일 경로를 저장할 테이블을 만든다. 
- ex_file 테이블을 정의한다.
- 이 테이블에 게시글 번호를 저장할 외부키 컬럼을 선언한다.
- "bitcamp-java-docs/bitcamp-java-project-v72.sql" 참조하라.

### 입력폼에 파일 항목을 추가한다.
- <input type="file"> 추가
- <form>의 enctype 속성 값을 "multipart/form-data"로 변경

### 파일 업로드 관련 객체를 스프링 설정 파일에 등록한다.
- dispatch-servlet.xml 에 multipartResolver 객체를 추가한다.

### 파일 업로드 관련 의존 라이브러리를 설정한다.
- build.gradle 파일에 의존 라이브러리 정보를 등록한다.
- mvnrepository.com에서 "commons-fileupload"을 검색한다.
- build.gradle 파일에 추가한 후 "gradle eclipse"를 실행한다.
- 프로젝트를 "refresh" 한다.

### 페이지 컨트롤러에서 업로드 파일을 받는다.
- 

### 업로드 파일 정보를 저장할 도메인 클래스를 만든다.
- java100.app.domain.UploadFile 클래스 작성

### Board 클래스에 첨부 파일 정보를 저장할 수 있도록 필드를 추가한다.

### 게시글 입력폼과 변경폼에 첨부파일 항목 추가한다.

### BoardController 변경
- 첨부파일을 받아서 저장하도록 변경한다.

### 
