/* 소스 파일 분리하기 II
- Maven 프로젝트의 디렉토리 구조를 알아보자!
- 왜 Maven 프로젝트의 디렉토리 구조를 사용하는가?
 */
class Test05 {
  public static void main(String[] args) {
    System.out.println("안녕하세요!");
  }
}

/* Maven 프로젝트 디렉토리 구조
   $프로젝트폴더
      /src
        /main
          /java       <= 자바 소스 파일을 두는 폴더
          /resources  <= 프로그램 설정 파일을 두는 폴더
          /webapp     <= 웹 애플리케이션 관련 파일을 두는 폴더 
        /test
          /java       <= 자바 테스트 소스 파일을 두는 폴더
          /resources  <= 자바 테스트 관련 설정 파일을 두는 폴더
  이유?
  - 국제적으로 자바 프로젝트를 관리할 때 이 구조를 많이 사용한다.
  - 국제 표준.
*/