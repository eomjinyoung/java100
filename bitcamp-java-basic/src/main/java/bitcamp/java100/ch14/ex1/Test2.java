// File System 다루기 : File 클래스
// => OS의 File System이 관리하는 파일 정보를 다룰 때 사용하는 클래스이다.
// => 디렉토리 정보도 이 클래스로 다룬다.
package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test2 {

    public static void main(String[] args) throws Exception {
        File file = new File("ok.txt");
        
        // 파일 생성
        // => 존재하지 않으면, 만들고 true 리턴
        // => 존재하면, 만들지 않고 false 리턴
        System.out.printf("파일생성=%b\n", file.createNewFile());
        
        // 파일 및 디렉토리 제거
        // => 삭제 성공하면, true 리턴
        // => 삭제 실패하면, false 리턴
        System.out.printf("파일삭제=%b\n", file.delete());
        
        // 디렉토리 생성
        File file2 = new File("dir1");
        //file2
    }

}









