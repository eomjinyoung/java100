// ## 문장(Statement) - 반복문 while
// - while 문 사용법을 알아보자!
//

package bitcamp.java100;

public class Test16_4 {

    public static void main(String[] args) {
        // => while 문법
        // - while (expression) 명령문
        // - expression의 실행 결과가 true이면 계속 명령문을 반복해서 실행한다.
        int i = 0;
        while (i < 5)
            System.out.println(i++);
        
        System.out.println("----------------------------");
        
        // => 여러 개의 문장을 반복하기 
        // - 블록을 사용하여 실행할 문장을 묶는다.
        i = 0;
        while (i < 5) {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        }
        
        System.out.println("----------------------------");
        
        // => while문의 중첩
        i = 1;
        while (i <= 5) {
            int count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
        
        // => while 문의 중법 연습
        // - 위의 결과처럼 *을 출력하되 다음과 같이 출력하라!
        //      *
        //     **
        //    ***
        //   ****
        //  *****
        i = 1;
        while (i <= 5) {
            int count = 5 - i;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
        
        // => while 문의 중법 연습 II
        // - 위의 결과를 다음과 같이 출력하라!
        //    *
        //   ***
        //  *****
        i = 1;
        while (i <= 5) {
            int count = 5 - i;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i++;
        }
        
    }
}













