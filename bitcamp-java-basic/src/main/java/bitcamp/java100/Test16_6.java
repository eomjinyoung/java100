// ## 문장(Statement) - 반복문 for
// - for 문 사용법을 알아보자!
//

package bitcamp.java100;

public class Test16_6 {

    public static void main(String[] args) {
        // => for 기본 문법
        // - for(변수 선언 및 초기화; 조건; 증가문) 명령문;
        for (int i = 0; i < 5; i++) 
            System.out.println(i);
        
        System.out.println("------------------");
        
        // => 변수는 여러개 선언할 수 있다.
        for (int i = 0, j = 0; i < 5; i++, j += 2) 
            System.out.printf("%d, %d\n", i, j);
        
        System.out.println("------------------");
       
        // => for 문에 선언된 변수는 for 블록 안에서만 사용한다.
        int sum = 0;
        for (int i = 1; i <= 10; i++)
            sum += i;
        System.out.println(sum);
        //System.out.println(i); // 컴파일 오류! i는 for 문의 로컬 변수이다.
        
        System.out.println("------------------");
        
    }
}














