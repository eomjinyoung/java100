# mybatis 사용법 익히기
- mybatis는 DBMS와 연동하여 데이터를 등록,조회,수정,삭제하는 작업을 도와준다.
- 이런 라이브러리를 "persistence API" 또는 "persistence framework"이라 부른다.
- JDBC 프로그래밍을 작성할 때 중복되는 코드를 별도의 라이브러리로 만든 것이다.
- 개발자가 직접 JDBC API를 사용하는 대신에 mybatis를 사용하여 데이터의 등록,조회,수정,삭제를 처리한다.
- 물론 mybatis는 내부적으로 JDBC API를 사용하여 처리한다.
- 따라서 mybatis를 사용하려면 여전히 JDBC Driver가 있어야 한다.

## 주요 목표
- 반복적인 JDBC 코딩을 대신 처리해주어 간결한 코드 작성을 도와준다!
- 자바 소스 코드에서 SQL문을 분리하여 코드의 유지보수를 쉽게 하도록 도와준다!

## step1
- mybatis 적용 전
- 직접 JDBC API를 사용하여 데이터 처리

## step2
- mybatis 라이브러리 준비 
- mybatis-config.xml 설정파일 준비
- SQL Mapper 파일 준비
- SqlSession 객체 준비 

## step3
- mybatis를 사용하여 select를 실행한다.





