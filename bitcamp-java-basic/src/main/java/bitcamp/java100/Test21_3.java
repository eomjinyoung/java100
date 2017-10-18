// ## 키보드로부터 입력 받기 - 활용
// - 키보드 입력을 받아서 처리하는 방법을 알아보자!
//

package bitcamp.java100;

import java.io.Console;

public class Test21_3 {
    public static void main(String[] args) {
        
        // 콘솔 객체를 준비한다.
        Console console = System.console();
        
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1); // JVM을 종료한다.
        }
        
        // 키보드로부터 입력 받은 값을 다음 변수에 채워라!
        String name;
        //int age;
        //boolean working;
        //float gpa;
        
        
        
        System.out.printf("이름: %s\n", name);
        //System.out.printf("나이: %d\n", age);
        //System.out.printf("재직여부: %b\n", working);
        //System.out.printf("졸업학점: %f\n", gpa);
        
    }
}











