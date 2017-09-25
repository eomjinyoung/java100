// # 자바에서 값 표현(literal)하기 - 문자
//
package bitcamp.java100;

public class Test11_2 {

    public static void main(String[] args) {
// 작은 따옴표('')를 사용하여 문자 한 개를 표현할 수 있다.
// => JVM에서는 문자 코드(유니코드)를 2바이트 메모리로 다룬다. 
        System.out.println('A');
        System.out.println('가');
        System.out.println('9');

// 문자에 대한 유니코드(2바이트) 값을 알고 있다면 그 값을 이용하여 문자를 표현할 수 있다.
// => 예) 'A'의 유니코드 = 0xAC00 
//        'A' 문자를 유니코드로 표현 = \uAC00'
        System.out.println('\u0041');
        System.out.println('\uAC00'); // = '\uac00'
        System.out.println('\u0039');
    }
}